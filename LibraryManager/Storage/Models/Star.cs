using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Storage.Models
{
    // Actor, Celebrity, Musican, Writer
    public class Star
    {

        public int Id { get; set; }
        public string Name { get; set; }
        public string ImageLink { get; set; }
        public int ItemsNumber { get { return Items.Count(); } }
        public int ItemsDone { get { return Items.Where(x => x.Done).Count(); } }
        public int Rank { get; set; }
        public bool Marked { get; set; }
        
        // custom info
        public List<Item> Items { get; set; } = new List<Item>();


        public DateTime? Timestamp { get; set; }

    }




}
