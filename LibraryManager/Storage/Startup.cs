using Storage.Models;
using Storage.Repositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Transactions;

namespace Storage
{
    class Startup
    {
        public static void Main(string[] args)
        {
            Populate();
        }

        public static void Populate()
        {
            using (var tr = new TransactionScope())
            {
                try
                {
                    var uow = new UnitOfWork();

                    var Anna = new Star()
                    {
                        Name = "John Smith",
                        Rank = 4
                    };
                    var Basia = new Star()
                    {
                        Name = "John Doe",
                        Rank = 4
                    };

                    uow.starRepo.Create(Anna);
                    uow.starRepo.Create(Basia);

                    var item1 = new Item()
                    {
                        Name = "movie1",
                        Type = "movie2"
                    };
                    uow.itemRepo.CreateItem(item1);
                    uow.SaveChanges();

                    item1.AddStar(Anna);
                    item1.AddStar(Basia);

                    uow.SaveChanges();

                    var stars = uow.starRepo.Stars().ToList();
                    var items = uow.itemRepo.GetItems();

                    tr.Complete();
                }
                catch (Exception e)
                {
                    throw e;
                }
            }
        }
    }
}
