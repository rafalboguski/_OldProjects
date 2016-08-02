using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Storage.Models
{
    public class Link
    {
        public int Id { get; set; }
        public int PartNumber { get; set; }
        public string Filename { get; set; }
        public string Password { get; set; }
        public string Url { get; set; }
        public string Site { get; set; }
        public int Size { get; set; }

        public bool Done { get; set; }
        public bool Dead { get; set; }


        public Item Item { get; set; }

        public DateTime? CreateDate { get; set; }
        public DateTime? Timestamp { get; set; }


    }
}
