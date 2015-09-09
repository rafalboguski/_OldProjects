using System.Collections.Generic;
using Microsoft.Data.Entity.Relational.Migrations;
using Microsoft.Data.Entity.Relational.Migrations.Builders;
using Microsoft.Data.Entity.Relational.Migrations.Operations;

namespace _Movies_App__MVC_6___Angular.Migrations
{
    public partial class _5 : Migration
    {
        public override void Up(MigrationBuilder migration)
        {
            migration.DropColumn(name: "Year", table: "Movie");
            migration.AddColumn(
                name: "CreateYear",
                table: "Movie",
                type: "int",
                nullable: true);
        }
        
        public override void Down(MigrationBuilder migration)
        {
            migration.DropColumn(name: "CreateYear", table: "Movie");
            migration.AddColumn(
                name: "Year",
                table: "Movie",
                type: "int",
                nullable: true);
        }
    }
}
