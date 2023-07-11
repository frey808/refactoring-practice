/**
 * A toy product.
 *
 * Created by robertstjacquesjr on 7/5/17.
 */
public class Toy extends Product {

    private final int minimumAge;
    private final boolean requiresBatteries;

    public Toy(String name, double price, int quantity, int minimumAge,
               boolean requiresBatteries) {
        super(name, price, quantity);
        this.minimumAge = minimumAge;
        this.requiresBatteries = requiresBatteries;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public boolean requiresBatteries() {
        return requiresBatteries;
    }
}
