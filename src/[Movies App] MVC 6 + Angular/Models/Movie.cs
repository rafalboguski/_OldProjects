using Microsoft.Data.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace _Movies_App__MVC_6___Angular.Models
{
    public class Movie
    {
        public int Id { get; set; }

        public string Title { get; set; }

        public string Director { get; set; }
    }

    public class MoviesAppContext : DbContext
    {

        public DbSet<Movie> Movies { get; set; }

    }
}
