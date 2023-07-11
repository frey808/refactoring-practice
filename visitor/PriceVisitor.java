import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PriceVisitor implements VisitorDouble {
    public double visit(Product p) {
        return p.getPrice();
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

    public List<Product> productsInPriceRange(Map<String,Product> inventory, int min, int max) {
        List<Product> inRange = new ArrayList<>();
        for(Product product : inventory.values()) {
            if((min < product.accept(this)) && (product.accept(this) < max)) {
                inRange.add(product);
            }
        }
        return inRange;
    }
}
