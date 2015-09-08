using Microsoft.AspNet.Identity;
using Microsoft.AspNet.Identity.EntityFramework;
using Microsoft.Data.Entity;
using System;

namespace _Movies_App__MVC_6___Angular.Models
{

    public class ApplicationUser : IdentityUser { }

    public class MoviesAppContext : IdentityDbContext<ApplicationUser>
    {
        public DbSet<Movie> Movies { get; set; }
    }

}

