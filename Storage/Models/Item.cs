using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace Storage.Models
{
    // song, movie, book
    public class Item
    {
        [Key]
        public int Id { get; set; }
        public string Type { get; set; }
        public string Name { get; set; }
        public string ImageLink { get; set; }

        public bool Done { get; set; }
        public bool ToFind { get; set; }
        public bool ToFindBetter { get; set; }

        public ICollection<ItemVersion> Versions { get; set; } = new List<ItemVersion>();
        public ICollection<Tag> Tags { get; set; } = new List<Tag>();
        public ICollection<Star> Stars { get; set; } = new List<Star>();

        public DateTime? CreateDate { get; set; }
        public DateTime? Timestamp { get; set; }
    }

    public class ItemVersion
    {
        [Key]
        public int Id { get; set; }
        public string Site { get; set; }
        public string Quality { get; set; }
        public int FileSize { get; set; }
        public int FileName { get; set; }
        public bool Done { get; set; }
        public int DoneLinks { get; set; }
        public int Parts { get; set; }

        public Item Item { get; set; }
        public ICollection<Link> Links { get; set; } = new List<Link>();

        public DateTime? CreateDate { get; set; }
    }
}
