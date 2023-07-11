import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuantityVisitor implements VisitorDouble {
    public double visit(Product p) {
        return p.getQuantity();
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

    public List<Product> productsToReorder(Map<String,Product> inventory) {
        List<Product> reorders = new ArrayList<>();
        for(Product product : inventory.values()) {
            if(product.accept(this) < 5) {
                reorders.add(product);
            }
        }
        return reorders;
    }

    public List<Product> productQuantityAbove(Map<String,Product> inventory, int min) {
        List<Product> above = new ArrayList<>();
        for(Product product : inventory.values()) {
            if(product.accept(this) > min) {
                above.add(product);
            }
        }
        return above;
    }
}
