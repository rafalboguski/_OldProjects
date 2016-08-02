using LinkManager.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinkManager
{
    class Item
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Type { get; set; }
        public int Quality { get; set; }
        public int Progress { get; set; }
        public DateTime Timestamp { get; set; }


        public Product Product { get; set; }

        public List<Link> Images { get; set; } = new List<Link>();
        public List<Link> Links { get; set; } = new List<Link>();
        public List<Tag> Tags { get; set; } = new List<Tag>();





    }
}
