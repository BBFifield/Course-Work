/**
 *
 * @author Brandon FIfield Student ID: 201238730
 */
public class Product {
    
    private final String name;
    private final String description;
    private final double unitPrice;
    private static int stock;
    
    public Product(String name, String description, double unitPrice) {
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        stock += 1;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public double getUnitPrice() {
        return unitPrice;
    }
    
    public int getStock() {
        return stock;
    }
    
    public void addToStock(int num) {
        stock += num;
    }
    
    public String toString() {
        return String.format("Name: %s%n Description: %s%n Product Price: %f%n # Left In Stock: #d", name, description, unitPrice, stock);
    }
}
