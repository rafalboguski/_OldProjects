using LinkManager.Model;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinkManager
{
    class AppContext : DbContext
    {
        public DbSet<Product> Products { get; set; }
        public DbSet<Item> Items { get; set; }
        public DbSet<Link> Links { get; set; }
        public DbSet<Tag> Tags { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {

            modelBuilder.Entity<Tag>()
                        .HasMany<Item>(s => s.Items)
                        .WithMany(c => c.Tags)
                        .Map(cs =>
                        {
                            cs.MapLeftKey("Tag_Id");
                            cs.MapRightKey("Item_Id");
                            cs.ToTable("TagItem");
                        });

        }


    }

    
}                                         
