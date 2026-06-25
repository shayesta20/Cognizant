import java.util.Arrays;
import java.util.Comparator;

public class ECommerceSearch {
    static class Product {
        String productId;
        String productName;
        String category;

        Product(String productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        @Override
        public String toString() {
            return String.format("Product{id=%s, name=%s, category=%s}", productId, productName, category);
        }
    }

    public static Product linearSearch(Product[] products, String searchName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(searchName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] sortedProducts, String searchName) {
        int left = 0;
        int right = sortedProducts.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int compare = sortedProducts[mid].productName.compareToIgnoreCase(searchName);
            if (compare == 0) {
                return sortedProducts[mid];
            }
            if (compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product("P001", "Sneakers", "Footwear"),
                new Product("P002", "Backpack", "Accessories"),
                new Product("P003", "Headphones", "Electronics"),
                new Product("P004", "Watch", "Accessories")
        };

        System.out.println("Linear search for Headphones:");
        System.out.println(linearSearch(products, "Headphones"));

        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, Comparator.comparing(p -> p.productName.toLowerCase()));

        System.out.println("\nBinary search for Watch:");
        System.out.println(binarySearch(sortedProducts, "Watch"));
    }
}
