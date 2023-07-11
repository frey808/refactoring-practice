import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MoviesByDirectorVisitor implements ProductVisitor {
    public double visit(Product p){
        return p.getQuantity() * p.getPrice();
    }

    public List<Movie> getMoviesByDirector(String director, Map<String, Product> inventory) {

        List<Movie> movies = new ArrayList<>();

        for(Product product : inventory.values()) {
            if(product.acceptString(this).equals(director)) {
                movies.add(product);
            }
        }

        return movies;

    }

    public double visit(Product p) {
        return null;
    }
}