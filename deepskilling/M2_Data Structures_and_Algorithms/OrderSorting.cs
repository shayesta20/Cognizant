using System;

public class OrderSorting
{
    public class Order
    {
        public string OrderId { get; set; }
        public string CustomerName { get; set; }
        public double TotalPrice { get; set; }

        public Order(string orderId, string customerName, double totalPrice)
        {
            OrderId = orderId;
            CustomerName = customerName;
            TotalPrice = totalPrice;
        }

        public override string ToString()
        {
            return $"Order{{id={OrderId}, customer={CustomerName}, total={TotalPrice:F2}}}";
        }
    }

    public static void BubbleSort(Order[] orders)
    {
        int n = orders.Length;
        for (int i = 0; i < n - 1; i++)
        {
            bool swapped = false;
            for (int j = 0; j < n - 1 - i; j++)
            {
                if (orders[j].TotalPrice > orders[j + 1].TotalPrice)
                {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
            {
                break;
            }
        }
    }

    public static void QuickSort(Order[] orders, int low, int high)
    {
        if (low < high)
        {
            int pivotIndex = Partition(orders, low, high);
            QuickSort(orders, low, pivotIndex - 1);
            QuickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int Partition(Order[] orders, int low, int high)
    {
        double pivot = orders[high].TotalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++)
        {
            if (orders[j].TotalPrice <= pivot)
            {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp1 = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp1;
        return i + 1;
    }

    public static void PrintOrders(string title, Order[] orders)
    {
        Console.WriteLine(title);
        foreach (var order in orders)
        {
            Console.WriteLine(order);
        }
    }

    public static void Main(string[] args)
    {
        Order[] orders = 
        {
            new Order("O100", "Alice", 150.00),
            new Order("O101", "Bob", 95.25),
            new Order("O102", "Charlie", 240.50),
            new Order("O103", "Dana", 120.75)
        };

        Order[] bubbleOrders = new Order[orders.Length];
        Array.Copy(orders, bubbleOrders, orders.Length);
        BubbleSort(bubbleOrders);
        PrintOrders("Bubble Sort result:", bubbleOrders);

        Order[] quickOrders = new Order[orders.Length];
        Array.Copy(orders, quickOrders, orders.Length);
        QuickSort(quickOrders, 0, quickOrders.Length - 1);
        PrintOrders("\nQuick Sort result:", quickOrders);
    }
}
