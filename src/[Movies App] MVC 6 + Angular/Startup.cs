using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNet.Builder;
using Microsoft.AspNet.Diagnostics;
using Microsoft.AspNet.Hosting;
using Microsoft.AspNet.Http;
using Microsoft.AspNet.Routing;
using Microsoft.Data.Entity;
using Microsoft.Framework.Configuration;
using Microsoft.Framework.DependencyInjection;
using Microsoft.Framework.Logging;

using Microsoft.Framework.Runtime;
using _Movies_App__MVC_6___Angular.Models;
using Microsoft.AspNet.Identity.EntityFramework;
using Microsoft.Data.Entity.SqlServer;
using Microsoft.AspNet.Identity;
using System.Security.Claims;

namespace _Movies_App__MVC_6___Angular
{
    public class Startup
    {

        public Startup(IHostingEnvironment env, IApplicationEnvironment appEnv)
        {
            // Setup configuration sources.

            var builder = new ConfigurationBuilder(appEnv.ApplicationBasePath)
                .AddJsonFile("config.json")
                .AddJsonFile($"config.{env.EnvironmentName}.json", optional: true);


            builder.AddEnvironmentVariables();
            Configuration = builder.Build();
        }

        public IConfiguration Configuration { get; set; }

        public void ConfigureServices(IServiceCollection services)
        {
            // add EF
            services.AddEntityFramework()
                .AddSqlServer()
                .AddDbContext<MoviesAppContext>(options =>
                {
                    options.UseSqlServer(Configuration["Data:DefaultConnection:ConnectionString"]);
                });

            // add ASP.NET Identity

            services.AddIdentity<ApplicationUser, IdentityRole>()
               .AddEntityFrameworkStores<MoviesAppContext>();


            // add MVC
            services.AddMvc();
        }

        public void Configure(IApplicationBuilder app)
        {

            app.UseIdentity();
            app.UseMvc();

            PopulateDB(app.ApplicationServices).Wait();
        }


        // populates db security
        private static async Task PopulateDB(IServiceProvider applicationServices)
        {
            using (var dbContext = applicationServices.GetService<MoviesAppContext>())
            {
                var sqlServerDatabase = dbContext.Database;
                if (sqlServerDatabase != null)
                {
                    // Create database in user root (c:\users\your name)
                    if (await sqlServerDatabase.EnsureCreatedAsync())
                    {
                        // add some movies
                        var movies = new List<Movie>
                        {
                            new Movie {Title="Star Wars", Director="Lucas"},
                            new Movie {Title="King Kong", Director="Jackson"},
                            new Movie {Title="Memento", Director="Nolan"}
                        };
                        movies.ForEach(m => dbContext.Add(m));

                        //add some users
                        var userManager = applicationServices.GetService<UserManager<ApplicationUser>>();

                        // add editor user
                        var stephen = new ApplicationUser
                        {
                            UserName = "Stephen"
                        };
                        var result = await userManager.CreateAsync(stephen, "P@ssw0rd");
                        await userManager.AddClaimAsync(stephen, new Claim("CanEdit", "true"));

                        // add normal user
                        var bob = new ApplicationUser
                        {
                            UserName = "Bob"
                        };
                        await userManager.CreateAsync(bob, "P@ssw0rd");
                    }

                }
                dbContext.SaveChanges();
            }
        }
    }
}
