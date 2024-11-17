package garment;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

class Garment {

    public String id;
    public String name;
    public String description;
    public String size;
    public String color;
    public double price;
    public int stockQuantity;

    // Constructor
    public Garment(String id, String name, String description, String size, String color, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.size = size;
        this.color = color;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    void updateStock(int quantity) {
        this.stockQuantity = quantity;
    }

    double calculateDiscountPrice(double discountPercentage) {
        double discount = price * (discountPercentage / 100);
        return price - discount;
    }

    // To display Garment details
    @Override
    public String toString() {
        return "Garment [ID=" + id + ", Name=" + name + ", Description=" + description + ", Size=" + size + ", Color=" + color + ", Price=" + price + ", Stock Quantity=" + stockQuantity + "]";
    }
}

class Fabric {

    public String id;
    public String type;
    public String color;
    public double pricePerMeter;

    // Constructor
    public Fabric(String id, String type, String color, double pricePerMeter) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.pricePerMeter = pricePerMeter;
    }

    double calculateCost(double meters) {
        return pricePerMeter * meters;
    }

    // To display Fabric details
    @Override
    public String toString() {
        return "Fabric [ID=" + id + ", Type=" + type + ", Color=" + color + ", Price Per Meter=" + pricePerMeter + "]";
    }
}

class Supplier {

    public String id;
    public String name;
    public String contactInfo;
    List<Fabric> suppliedFabric;

    // Constructor
    public Supplier(String id, String name, String contactInfo) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.suppliedFabric = new ArrayList<>();
    }

    void addFabric(Fabric fabric) {
        suppliedFabric.add(fabric);
    }

    List<Fabric> getSuppliedFabrics() {
        return suppliedFabric;
    }

    // To display Supplier details
    @Override
    public String toString() {
        return "Supplier [ID=" + id + ", Name=" + name + ", Contact Info=" + contactInfo + "]";
    }
}

class Order {

    public String orderId;
    public Date orderDate;
    public List<Garment> garments;
    private double totalAmount;

    // Constructor
    public Order(String orderId) {
        this.orderId = orderId;
        this.orderDate = new Date();  // Set the current date
        this.garments = new ArrayList<>();
    }

    void addGarment(Garment garment) {
        garments.add(garment);
    }

    double calculateTotalAmount() {
        totalAmount = 0;
        for (Garment g : garments) {
            totalAmount += g.price;
        }
        return totalAmount;
    }

    void printOrderDetails() {
        System.out.println("--------------------------");
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("--------------------------");
        for (Garment g : garments) {
            System.out.println("Garment: " + g.name + ", Price: " + g.price);
        }
        System.out.println("Total Amount: " + calculateTotalAmount());
        System.out.println("--------------------------");
    }
}

class Customer {

    public String customerId;
    public String name;
    public String email;
    public String phone;

    // Constructor
    public Customer(String customerId, String name, String email, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    void placeOrder(Order order) {
        order.printOrderDetails();
        System.out.println("Order Placed");
    }
}

class Inventory {

    List<Garment> garments;

    // Constructor
    public Inventory() {
        garments = new ArrayList<>();
    }

    void addGarment(Garment garment) {
        garments.add(garment);
    }

    void removeGarment(String id) {
        garments.removeIf(g -> g.id.equals(id));
    }

    Garment findGarment(String id) {
        for (Garment g : garments) {
            if (g.id.equals(id)) {
                return g;
            }
        }
        return null;
    }

    // Display all garments in inventory
    void displayGarments() {
        for (Garment g : garments) {
            System.out.println(g);
        }
    }
}

public class GarmentSystem {

    public static void main(String[] args) {
        // Creating Garment objects
        Garment g1 = new Garment("G001", "Silk Shirt", "Comfortable and stylish", "M", "Blue", 45.99, 100);
        Garment g2 = new Garment("G002", "Cotton T-Shirt", "Soft and breathable", "L", "White", 25.99, 200);

        // Creating Inventory object and adding garments
        Inventory inventory = new Inventory();
        inventory.addGarment(g1);
        inventory.addGarment(g2);

        // Display Inventory
        System.out.println("Inventory:");
        inventory.displayGarments();

        // Creating Supplier object
        Supplier supplier = new Supplier("S001", "ABC Fabrics", "abc@fabricsupplier.com");
        Fabric fabric1 = new Fabric("F001", "Cotton", "White", 10.0);
        Fabric fabric2 = new Fabric("F002", "Silk", "Blue", 20.0);
        supplier.addFabric(fabric1);
        supplier.addFabric(fabric2);

        // Display Supplier details and supplied fabrics
        System.out.println("\nSupplier Details:");
        System.out.println(supplier);
        System.out.println("Supplied Fabrics:");
        for (Fabric fabric : supplier.getSuppliedFabrics()) {
            System.out.println(fabric);
        }

        // Creating Customer object
        Customer customer = new Customer("C001", "John Doe", "john.doe@example.com", "123-456-7890");

        // Creating Order object
        Order order = new Order("O001");
        order.addGarment(g1);
        order.addGarment(g2);

        // Customer places an order
        System.out.println("\nCustomer Order Details:");
        customer.placeOrder(order);
    }
}