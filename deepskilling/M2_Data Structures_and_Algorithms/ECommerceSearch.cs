using System;

public class ECommerceSearch
{
    public class Product
    {
        public string ProductId { get; set; }
        public string ProductName { get; set; }
        public string Category { get; set; }

        public Product(string productId, string productName, string category)
        {
            ProductId = productId;
            ProductName = productName;
            Category = category;
        }

        public override string ToString()
        {
            return $"Product{{id={ProductId}, name={ProductName}, category={Category}}}";
        }
    }

    public static Product LinearSearch(Product[] products, string searchName)
    {
        foreach (Product product in products)
        {
            if (string.Equals(product.ProductName, searchName, StringComparison.OrdinalIgnoreCase))
            {
                return product;
            }
        }
        return null;
    }

    public static Product BinarySearch(Product[] sortedProducts, string searchName)
    {
        int left = 0;
        int right = sortedProducts.Length - 1;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            int compare = string.Compare(sortedProducts[mid].ProductName, searchName, StringComparison.OrdinalIgnoreCase);

            if (compare == 0)
            {
                return sortedProducts[mid];
            }
            if (compare < 0)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void Main(string[] args)
    {
        Product[] products = new Product[]
        {
            new Product("P001", "Sneakers", "Footwear"),
            new Product("P002", "Backpack", "Accessories"),
            new Product("P003", "Headphones", "Electronics"),
            new Product("P004", "Watch", "Accessories")
        };

        Console.WriteLine("Linear search for Headphones:");
        Product linearResult = LinearSearch(products, "Headphones");
        Console.WriteLine(linearResult != null ? linearResult.ToString() : "Not Found");

        // Create a copy of the array and sort it
        Product[] sortedProducts = new Product[products.Length];
        Array.Copy(products, sortedProducts, products.Length);
        
        // Sorting alphabetically by product name (case-insensitive)
        Array.Sort(sortedProducts, (p1, p2) => string.Compare(p1.ProductName, p2.ProductName, StringComparison.OrdinalIgnoreCase));

        Console.WriteLine("\nBinary search for Watch:");
        Product binaryResult = BinarySearch(sortedProducts, "Watch");
        Console.WriteLine(binaryResult != null ? binaryResult.ToString() : "Not Found");
    }
}
