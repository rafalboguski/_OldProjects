﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNet.Mvc;
using _Movies_App__MVC_6___Angular.Models;
using Microsoft.Data.Entity;
using _Movies_App__MVC_6___Angular.Services.Logging;

// For more information on enabling Web API for empty projects, visit http://go.microsoft.com/fwlink/?LinkID=397860

namespace _Movies_App__MVC_6___Angular.API
{
    [Route("api/[controller]")]
    public class MoviesController : Controller
    {
        private readonly MoviesAppContext _dbContext;

        public MoviesController(MoviesAppContext dbContext)
        {
            _dbContext = dbContext;
        }

        [HttpGet]
        public IEnumerable<Movie> Get()
        {
            Logger.ReqRes("GET: " + Request.Path, Response.StatusCode);
            return _dbContext.Movies.AsNoTracking();
        }


        [HttpGet("{id:int}")]
        public IActionResult Get(int id)
        {
            
            var movie = _dbContext.Movies.AsNoTracking().FirstOrDefault(m => m.Id == id);
            if (movie == null)
            {
                Logger.ReqRes("GET: " + Request.Path, new HttpNotFoundResult().StatusCode);
                return new HttpNotFoundResult();
            }
            else
            {
                Logger.ReqRes("GET: " + Request.Path, Response.StatusCode);
                return new ObjectResult(movie);
            }
        }


        [HttpPost]
        public IActionResult Post([FromBody]Movie movie)
        {
            if (ModelState.IsValid)
            {
                if (movie.Id == 0)
                {
                    _dbContext.Movies.Add(movie);
                    _dbContext.SaveChanges();
                    return new ObjectResult(movie);
                }
                else
                {
                    var original = _dbContext.Movies.FirstOrDefault(m => m.Id == movie.Id);
                    original.Title = movie.Title;
                    original.Director = movie.Director;
                    original.TicketPrice = movie.TicketPrice;

                    _dbContext.SaveChanges();
                    return new ObjectResult(original);
                }
            }
            return new BadRequestObjectResult(ModelState);
        }


        [HttpDelete("{id:int}")]
        public IActionResult Delete(int id)
        {
            var movie = _dbContext.Movies.FirstOrDefault(m => m.Id == id);
            _dbContext.Movies.Remove(movie);
            _dbContext.SaveChanges();
            return new HttpStatusCodeResult(200);
        }


    }
}
