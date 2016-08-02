using LinkManager.Model;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinkManager.Repo
{
    static class LinksRepo
    {

        public static List<Link> getLinks(AppContext db, int itemId)
        {
            var links = db.Links.Where(x => x.Item.Id == itemId).ToList();

            return links;

        }

        public static void CreateLink(AppContext db, string adress, string name, int itemId)
        {
            var link = new Link { Adress = adress, Name = name };
            var item = db.Items.Single(i => i.Id == itemId);

            link.Item = item;
            db.Links.Add(link);

            item.Links.Add(link);
            db.SaveChanges();

        }

        public static void DeleteLink(AppContext db, int linkId)
        {
            var link = db.Links.Single(x => x.Id == linkId);
            db.Links.Remove(link);
            db.SaveChanges();
        }

        public static void LinkStatus(AppContext db, int linkId, bool done)
        {
            var link = db.Links.Single(x => x.Id == linkId);
            link.Done = done;
            db.SaveChanges();

        }

    }
}
