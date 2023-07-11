import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MovieDirectorVisitor implements VisitorString {
    public String visit(Movie m) {
        return m.getDirector();
    }

    public String visit(Food f) {
        return visit((Product)f);
    }

    public String visit(Toy t) {
        return visit((Product)t);
    }

    public String visit(Book b) {
        return visit((Product)b);
    }

    public String visit(Product p) {
        return null;
    }

    public List<Movie> moviesByDirector(Map<String,Product> inventory, String director) {
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
}
