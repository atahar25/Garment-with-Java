package garment;

import java.util.ArrayList;
import java.util.List;

class Garment {

    public String id;
    public String name;
    public String description;
    public String size;
    public String color;
    public double price;
    public int stockQuantity;

    void updateStock(int quantity) {
        this.stockQuantity = quantity;
    }

    double calculateDiscountPrice(double discountPercentage) {
        double discount = price * (discountPercentage / 100);
        return discount;
    }
}

class Fabric {

    public String id;
    public String type;
    public String color;
    public double pricePerMeter;

    double calculateCost(double meters) {
        double newPrice = pricePerMeter * meters;
        return newPrice;
    }
}

class Supplier {

    public String id;
    public String name;
    public String contactInfo;
    //List
    List<Fabric> suppliedFabric = new ArrayList<>();

    void addFabric(Fabric fabric) {
        suppliedFabric.add(fabric);
    }

    List<Fabric> getSuppliedFabrics() {
        return suppliedFabric;
    }
}
public class system {
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
