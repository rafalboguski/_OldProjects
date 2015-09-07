using Microsoft.Data.Entity;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace _Movies_App__MVC_6___Angular.Models
{
    public class Movie
    {
        public int Id { get; set; }

        [Required(ErrorMessage= "Movie Title is Required")]
        [MinLength(3, ErrorMessage= "Movie Title must be at least 3 characters")]
        public string Title { get; set; }

        [Required(ErrorMessage ="Movie Director is Requiered.")]
        public string Director { get; set; }

        [Range(0,100,ErrorMessage = "Ticket price must be between 0 and 100 dollars.")]
        public decimal TicketPrice { get; set; }

    }

    public class MoviesAppContext : DbContext
    {

        public DbSet<Movie> Movies { get; set; }

    }
}
