using System.Collections.Generic;
using Microsoft.Data.Entity.Relational.Migrations;
using Microsoft.Data.Entity.Relational.Migrations.Builders;
using Microsoft.Data.Entity.Relational.Migrations.Operations;

namespace _Movies_App__MVC_6___Angular.Migrations
{
    public partial class sdf : Migration
    {
        public override void Up(MigrationBuilder migration)
        {
            migration.DropColumn(name: "ReleaseDate", table: "Movie");
        }
        
        public override void Down(MigrationBuilder migration)
        {
            migration.AddColumn(
                name: "ReleaseDate",
                table: "Movie",
                type: "datetime2",
                nullable: false);
        }
    }
}
