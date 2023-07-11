import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductsToReorderVisitor implements ProductVisitor {
    public double visit(Product p){
        return p.getQuantity();
    }

    public List<Product> getProducts(Map<String,Product> inventory) {
        List<Product> reorders = new ArrayList<>();

        for(Product product : inventory.values()) {
            if(product.accept(this) < 5) {
                reorders.add(product);
            }
        }

        return reorders;
    }

    public String visitString(Product p) {
        return null;
    }
}