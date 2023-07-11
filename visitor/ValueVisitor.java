import java.util.Map;

public class ValueVisitor implements VisitorDouble {
    public double visit(Product p) {
        return p.getPrice() * p.getQuantity();
    }

    public double visit(Food f) {
        return visit((Product)f);
    }

    public double visit(Movie m) {
        return visit((Product)m);
    }

    public double visit(Book b) {
        return visit((Product)b);
    }

    public double visit(Toy t) {
        return visit((Product)t);
    }
    
    public double totalValue(Map<String, Product> inventory){
        double value = 0;
        for(Product product : inventory.values()) {
            value = value + product.accept(this);
        }
        return value;
    }
}
