using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Storage.Models
{
    public class AppDbContext : DbContext
    {
        public AppDbContext() : base(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=C:\Users\rbog\Documents\Storage_Library.mdf;Integrated Security=True;Connect Timeout=30")
        {

        }

        public static AppDbContext Create()
        {
            return new AppDbContext();
        }

        public DbSet<Star> Stars { get; set; }
        public DbSet<Item> Items { get; set; }
        public DbSet<ItemVersion> ItemsVersions { get; set; }
        public DbSet<Tag> Tags { get; set; }
        public DbSet<Link> Links { get; set; }

    }
}
