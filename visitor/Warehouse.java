import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A warehouse of products.
 */
public class Warehouse {
    private Map<String, Product> inventory;

    public Warehouse() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getName(), product);
    }

    // product queries

    public double getTotalInventoryValue() {
        double value = 0;

        for(Product product : inventory.values()) {
            value = value + (product.getPrice() * product.getQuantity());
        }

        return value;
    }

    public List<Product> getProductsToReorder() {
        List<Product> reorders = new ArrayList<>();

        for(Product product : inventory.values()) {
            if(product.getQuantity() < 5) {
                reorders.add(product);
            }
        }

        return reorders;
    }

    public List<Movie> getMoviesByDirector(String director) {

        List<Movie> movies = new ArrayList<>();

        for(Product product : inventory.values()) {
            if(product instanceof Movie) {
                Movie movie = (Movie)product;
                if(movie.getDirector().equals(director)) {
                    movies.add(movie);
                }
            }
        }

        return movies;

    }

    public List<Toy> getToysSuitableForAge(int age) {
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

    public double visitorTotalInventoryValue() {
        ValueVisitor visitor = new ValueVisitor();
        return visitor.totalValue(inventory);
    }

    public List<Product> visitorProductsToReorder() {
        QuantityVisitor visitor = new QuantityVisitor();
        return visitor.productsToReorder(inventory);
    }

    public List<Movie> visitorMoviesByDirector(String director) {
        MovieDirectorVisitor visitor = new MovieDirectorVisitor();
        return visitor.moviesByDirector(inventory, director);
    }

    public List<Toy> visitorToysSuitableForAge(int age) {
        ToyMinimumAgeVisitor visitor = new ToyMinimumAgeVisitor();
        return visitor.toysSuitableForAge(inventory, age);
    }

    public List<Product> visitorProductsInPriceRange(int min, int max) {
        PriceVisitor visitor = new PriceVisitor();
        return visitor.productsInPriceRange(inventory, min, max);
    }

    public List<Product> visitorProductsQuantityAbove(int min) {
        QuantityVisitor visitor = new QuantityVisitor();
        return visitor.productQuantityAbove(inventory, min);
    }
}
