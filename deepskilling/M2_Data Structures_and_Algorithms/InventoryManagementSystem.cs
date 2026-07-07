using System;
using System.Collections.Generic;
using System.Linq;

public class InventoryManagementSystem
{
    public class Product
    {
        public string ProductId { get; set; }
        public string ProductName { get; set; }
        public int Quantity { get; set; }
        public double Price { get; set; }

        public Product(string productId, string productName, int quantity, double price)
        {
            ProductId = productId;
            ProductName = productName;
            Quantity = quantity;
            Price = price;
        }

        public override string ToString()
        {
            return $"Product{{id={ProductId}, name={ProductName}, quantity={Quantity}, price={Price:F2}}}";
        }
    }

    private readonly Dictionary<string, Product> _inventory = new Dictionary<string, Product>();

    public void AddProduct(Product product)
    {
        _inventory[product.ProductId] = product;
    }

    public bool UpdateProduct(string productId, int quantity, double price)
    {
        if (!_inventory.TryGetValue(productId, out Product product))
        {
            return false;
        }
        product.Quantity = quantity;
        product.Price = price;
        return true;
    }

    public bool DeleteProduct(string productId)
    {
        return _inventory.Remove(productId);
    }

    public Product GetProduct(string productId)
    {
        _inventory.TryGetValue(productId, out Product product);
        return product;
    }

    public void PrintInventory()
    {
        if (_inventory.Count == 0)
        {
            Console.WriteLine("Inventory is empty.");
            return;
        }
        foreach (var product in _inventory.Values)
        {
            Console.WriteLine(product);
        }
    }

    public static void Main(string[] args)
    {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        ims.AddProduct(new Product("P001", "Widget", 25, 9.99));
        ims.AddProduct(new Product("P002", "Gadget", 40, 14.50));
        ims.AddProduct(new Product("P003", "Sprocket", 15, 24.75));

        Console.WriteLine("Initial inventory:");
        ims.PrintInventory();

        ims.UpdateProduct("P002", 35, 13.99);

        Console.WriteLine("\nAfter updating P002:");
        Console.WriteLine(ims.GetProduct("P002"));

        ims.DeleteProduct("P001");

        Console.WriteLine("\nAfter deleting P001:");
        ims.PrintInventory();
    }
}
