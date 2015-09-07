using System.Collections.Generic;
using Microsoft.Data.Entity.Relational.Migrations;
using Microsoft.Data.Entity.Relational.Migrations.Builders;
using Microsoft.Data.Entity.Relational.Migrations.Operations;

namespace _Movies_App__MVC_6___Angular.Migrations
{
    public partial class MovieModelValidation : Migration
    {
        public override void Up(MigrationBuilder migration)
        {
            migration.AddColumn(
                name: "ReleaseDate",
                table: "Movie",
                type: "datetime2",
                nullable: false);
            migration.AddColumn(
                name: "TicketPrice",
                table: "Movie",
                type: "decimal(18, 2)",
                nullable: false);
        }
        
        public override void Down(MigrationBuilder migration)
        {
            migration.DropColumn(name: "ReleaseDate", table: "Movie");
            migration.DropColumn(name: "TicketPrice", table: "Movie");
        }
    }
}
