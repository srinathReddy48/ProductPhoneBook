import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProductPhoneBook {

    private static Map<String, Product> productMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\nProduct Phone Book Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. View Product Details");
            System.out.println("3. List All Products");
            System.out.println("4. Update Product Price");
            System.out.println("5. Update Product Rating");
            System.out.println("6. Delete Product");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewProductDetails();
                    break;
                case 3:
                    listAllProducts();
                    break;
                case 4:
                    updateProductPrice();
                    break;
                case 5:
                    updateProductRating();
                    break;
                case 6:
                    deleteProduct();
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting Product Phone Book. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter product rating (1-5): ");
        int rating = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (rating < 1 || rating > 5) {
            System.out.println("Invalid rating. Rating must be between 1 and 5.");
            return;
        }

        Product newProduct = new Product(name, price, rating);
        productMap.put(name, newProduct);

        System.out.println("Product added successfully!");
    }

    private static void viewProductDetails() {
        System.out.print("Enter product name to view details: ");
        String name = scanner.nextLine();

        if (productMap.containsKey(name)) {
            Product product = productMap.get(name);
            System.out.println(product); // Uses the toString method in Product class
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void listAllProducts() {
        if (productMap.isEmpty()) {
            System.out.println("No products in the phone book.");
            return;
        }

        System.out.println("All Products:");
        for (Product product : productMap.values()) {
            System.out.println(product); // Uses the toString method in Product class
        }
    }

    private static void updateProductPrice() {
        System.out.print("Enter product name to update price: ");
        String name = scanner.nextLine();

        if (productMap.containsKey(name)) {
            System.out.print("Enter new price: ");
            double newPrice = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            Product product = productMap.get(name);
            product.setPrice(newPrice);
            System.out.println("Product price updated successfully!");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void updateProductRating() {
        System.out.print("Enter product name to update rating: ");
        String name = scanner.nextLine();

        if (productMap.containsKey(name)) {
            System.out.print("Enter new rating (1-5): ");
            int newRating = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (newRating < 1 || newRating > 5) {
                System.out.println("Invalid rating. Rating must be between 1 and 5.");
                return;
            }

            Product product = productMap.get(name);
            product.setRating(newRating);
            System.out.println("Product rating updated successfully!");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void deleteProduct() {
        System.out.print("Enter product name to delete: ");
        String name = scanner.nextLine();

        if (productMap.containsKey(name)) {
            productMap.remove(name);
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Inner class to represent a Product
    static class Product {
        private String name;
        private double price;
        private int rating;

        public Product(String name, double price, int rating) {
            this.name = name;
            this.price = price;
            this.rating = rating;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        @Override
        public String toString() {
            return "Product Name: " + name +
                   ", Price: $" + String.format("%.2f", price) +
                   ", Rating: " + rating + " stars";
        }
    }
}
