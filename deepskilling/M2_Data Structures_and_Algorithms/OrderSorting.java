import java.util.Arrays;

public class OrderSorting {
    static class Order {
        String orderId;
        String customerName;
        double totalPrice;

        Order(String orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        @Override
        public String toString() {
            return String.format("Order{id=%s, customer=%s, total=%.2f}", orderId, customerName, totalPrice);
        }
    }

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void printOrders(String title, Order[] orders) {
        System.out.println(title);
        Arrays.stream(orders).forEach(System.out::println);
    }

    public static void main(String[] args) {
        Order[] orders = {
                new Order("O100", "Alice", 150.00),
                new Order("O101", "Bob", 95.25),
                new Order("O102", "Charlie", 240.50),
                new Order("O103", "Dana", 120.75)
        };

        Order[] bubbleOrders = Arrays.copyOf(orders, orders.length);
        bubbleSort(bubbleOrders);
        printOrders("Bubble Sort result:", bubbleOrders);

        Order[] quickOrders = Arrays.copyOf(orders, orders.length);
        quickSort(quickOrders, 0, quickOrders.length - 1);
        printOrders("\nQuick Sort result:", quickOrders);
    }
}
