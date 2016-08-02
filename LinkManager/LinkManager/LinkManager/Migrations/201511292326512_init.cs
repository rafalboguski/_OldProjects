namespace LinkManager.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class init : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Items",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Name = c.String(),
                        Type = c.String(),
                        Quality = c.Int(nullable: false),
                        Progress = c.Int(nullable: false),
                        Timestamp = c.DateTime(nullable: false),
                        Product_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Products", t => t.Product_Id)
                .Index(t => t.Product_Id);
            
            CreateTable(
                "dbo.Links",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Name = c.String(),
                        Adress = c.String(),
                        Done = c.Boolean(nullable: false),
                        Item_Id = c.Int(),
                        Item_Id1 = c.Int(),
                        Item_Id2 = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Items", t => t.Item_Id)
                .ForeignKey("dbo.Items", t => t.Item_Id1)
                .ForeignKey("dbo.Items", t => t.Item_Id2)
                .Index(t => t.Item_Id)
                .Index(t => t.Item_Id1)
                .Index(t => t.Item_Id2);
            
            CreateTable(
                "dbo.Products",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        name = c.String(),
                        Quality = c.Int(nullable: false),
                        Progress = c.Int(nullable: false),
                        Timestamp = c.DateTime(nullable: false),
                        Image_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Links", t => t.Image_Id)
                .Index(t => t.Image_Id);
            
            CreateTable(
                "dbo.Tags",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Name = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.TagItem",
                c => new
                    {
                        Tag_Id = c.Int(nullable: false),
                        Item_Id = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.Tag_Id, t.Item_Id })
                .ForeignKey("dbo.Tags", t => t.Tag_Id, cascadeDelete: true)
                .ForeignKey("dbo.Items", t => t.Item_Id, cascadeDelete: true)
                .Index(t => t.Tag_Id)
                .Index(t => t.Item_Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.TagItem", "Item_Id", "dbo.Items");
            DropForeignKey("dbo.TagItem", "Tag_Id", "dbo.Tags");
            DropForeignKey("dbo.Items", "Product_Id", "dbo.Products");
            DropForeignKey("dbo.Products", "Image_Id", "dbo.Links");
            DropForeignKey("dbo.Links", "Item_Id2", "dbo.Items");
            DropForeignKey("dbo.Links", "Item_Id1", "dbo.Items");
            DropForeignKey("dbo.Links", "Item_Id", "dbo.Items");
            DropIndex("dbo.TagItem", new[] { "Item_Id" });
            DropIndex("dbo.TagItem", new[] { "Tag_Id" });
            DropIndex("dbo.Products", new[] { "Image_Id" });
            DropIndex("dbo.Links", new[] { "Item_Id2" });
            DropIndex("dbo.Links", new[] { "Item_Id1" });
            DropIndex("dbo.Links", new[] { "Item_Id" });
            DropIndex("dbo.Items", new[] { "Product_Id" });
            DropTable("dbo.TagItem");
            DropTable("dbo.Tags");
            DropTable("dbo.Products");
            DropTable("dbo.Links");
            DropTable("dbo.Items");
        }
    }
}
