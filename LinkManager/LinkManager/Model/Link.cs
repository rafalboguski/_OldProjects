using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinkManager.Model
{
    class Link
    {

        public int Id { get; set; }

        public string Name { get; set; }

        public string Adress { get; set; }

        public bool Done { get; set; }

        public Item Item { get; set; }

    }
}
