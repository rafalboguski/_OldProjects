using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinkManager.Model
{
    class Product
    {

        public int Id { get; set; }
        public string name { get; set; }
        public int Quality { get; set; }
        public int Progress { get; set; }
        public DateTime Timestamp { get; set; }

        public Link Image { get; set; }

        public List<Item> items { get; set; } = new List<Item>();

    }
}
