using Storage.Models;
using System.Collections.Generic;
using System.Linq;

public class ItemRepository
{
    private readonly AppDbContext _db;

    public ItemRepository(AppDbContext dbContext)
    {
        _db = dbContext;
    }

    public Item GetItem(int? id = null, string name = null)
    {
        if (id != null)
            return _db.Items.Single(x => x.Id == id);
        if (name != null)
            return _db.Items.Single(x => x.Name == name);
        return null;
    }

    public ItemVersion GetItemVersion(int id)
    {
        return _db.ItemsVersions.Single(x => x.Id == id);
    }

    public ICollection<Item> GetItems()
    {
        return _db.Items.OrderByDescending(x => x.Timestamp).ToList();
    }

    public ICollection<ItemVersion> GetItemVersions(int? itemId = null, string itemName = null)
    {
        var item = GetItem(id: itemId, name: itemName);
        return item.Versions.OrderByDescending(x => x.FileSize).ToList();
    }

    public Item CreateItem(Item model)
    {
        _db.Items.Add(model);
        return model;
    }

    public ItemVersion CreateItemVersion(ItemVersion model)
    {
        _db.ItemsVersions.Add(model);
        return model;
    }

    public void DeleteItem(int id)
    {
        var item = GetItem(id);
        if (item.Versions.Count() == 0)
            _db.Items.Remove(GetItem(id));
    }

    public void DeleteItemVersion(int id)
    {
        var version = GetItemVersion(id);
        if (version.Links.Count() == 0)
            _db.ItemsVersions.Remove(version);
    }

}
