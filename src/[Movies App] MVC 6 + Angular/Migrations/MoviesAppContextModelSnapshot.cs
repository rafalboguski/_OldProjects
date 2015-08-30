using System;
using Microsoft.Data.Entity;
using Microsoft.Data.Entity.Metadata;
using Microsoft.Data.Entity.Relational.Migrations.Infrastructure;
using _Movies_App__MVC_6___Angular.Models;

namespace _Movies_App__MVC_6___Angular.Migrations.Migrations
{
    [ContextType(typeof(MoviesAppContext))]
    partial class MoviesAppContextModelSnapshot : ModelSnapshot
    {
        public override void BuildModel(ModelBuilder builder)
        {
            builder
                .Annotation("SqlServer:DefaultSequenceName", "DefaultSequence")
                .Annotation("SqlServer:Sequence:.DefaultSequence", "'DefaultSequence', '', '1', '10', '', '', 'Int64', 'False'")
                .Annotation("SqlServer:ValueGeneration", "Sequence");
            
            builder.Entity("_Movies_App__MVC_6___Angular.Models.Movie", b =>
                {
                    b.Property<int>("Id")
                        .GenerateValueOnAdd()
                        .StoreGeneratedPattern(StoreGeneratedPattern.Identity);
                    
                    b.Property<string>("Director");
                    
                    b.Property<string>("Title");
                    
                    b.Key("Id");
                });
        }
    }
}
