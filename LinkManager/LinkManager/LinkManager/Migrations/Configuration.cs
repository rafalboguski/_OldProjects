namespace LinkManager.Migrations
{
    using Model;
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;

    internal sealed class Configuration : DbMigrationsConfiguration<LinkManager.AppContext>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = false;
        }

        protected override void Seed(LinkManager.AppContext context)
        {
            //  This method will be called after migrating to the latest version.

            //  You can use the DbSet<T>.AddOrUpdate() helper extension method 
            //  to avoid creating duplicate seed data. E.g.
            //
            if (context.Products.Count() == 0)
            {
                context.Products.Add(new Product { name = "Tom Hanks", Timestamp = DateTime.Now });
                context.Products.Add(new Product { name = "Kulfon", Timestamp = DateTime.Now });
                context.Products.Add(new Product { name = "Johny Travolta", Timestamp = DateTime.Now });

                context.SaveChanges();

            }
            
        }
    }
}
