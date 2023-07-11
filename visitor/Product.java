/**
 * Class for a simple product.
 */
public class Product {
    private final String name;
    private final double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void adjustQuantity(int amount) {
        this.quantity += amount;
    }

    public double accept(VisitorDouble visitor){
        return visitor.visit(this);
    }

    public String accept(VisitorString visitor){
        return visitor.visit(this);
    }
}
