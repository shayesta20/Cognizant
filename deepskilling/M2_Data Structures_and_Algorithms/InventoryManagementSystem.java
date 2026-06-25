import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem {
    static class Product {
        String productId;
        String productName;
        int quantity;
        double price;

        Product(String productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        @Override
        public String toString() {
            return String.format("Product{id=%s, name=%s, quantity=%d, price=%.2f}",
                    productId, productName, quantity, price);
        }
    }

    private final Map<String, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        inventory.put(product.productId, product);
    }

    public boolean updateProduct(String productId, int quantity, double price) {
        Product product = inventory.get(productId);
        if (product == null) {
            return false;
        }
        product.quantity = quantity;
        product.price = price;
        return true;
    }

    public boolean deleteProduct(String productId) {
        return inventory.remove(productId) != null;
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    public void printInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        inventory.values().forEach(System.out::println);
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        ims.addProduct(new Product("P001", "Widget", 25, 9.99));
        ims.addProduct(new Product("P002", "Gadget", 40, 14.50));
        ims.addProduct(new Product("P003", "Sprocket", 15, 24.75));

        System.out.println("Initial inventory:");
        ims.printInventory();

        ims.updateProduct("P002", 35, 13.99);
        System.out.println("\nAfter updating P002:");
        System.out.println(ims.getProduct("P002"));

        ims.deleteProduct("P001");
        System.out.println("\nAfter deleting P001:");
        ims.printInventory();
    }
}
