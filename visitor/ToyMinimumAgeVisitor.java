import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ToyMinimumAgeVisitor implements VisitorDouble {
    public double visit(Toy t) {
        return t.getMinimumAge();
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

    public double visit(Product p) {
        return -1;
    }

    public List<Toy> toysSuitableForAge(Map<String,Product> inventory, int age) {
        List<Toy> toys = new ArrayList<>();
        for(Product product : inventory.values()) {
            if(product instanceof  Toy) {
                Toy toy = (Toy)product;
                if(toy.getMinimumAge() >= age) {
                    toys.add(toy);
                }
            }
        }
        return toys;
    }
}
