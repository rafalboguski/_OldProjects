﻿using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Storage.Models
{
    public class Tag
    {
        [Key]
        public string Name { get; set; }
        public ICollection<Item> Items { get; set; } = new HashSet<Item>();
    }
}
