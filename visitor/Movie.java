/**
 * A movie product.
 */
public class Movie extends Product {
    public enum Rating {
        G,
        PG,
        PG_13,
        R,
        NC_17,
        UNRATED
    }

    private final Rating rating;
    private final String director;


    public Movie(String name, double price, int quantity, String director,
                 Rating rating) {
        super(name, price, quantity);
        this.director = director;
        this.rating = rating;
    }

    public Rating getRating() {
        return rating;
    }

    public String getDirector() {
        return director;
    }

    public double accept(VisitorDouble visitor){
        return visitor.visit(this);
    }

    public String accept(VisitorString visitor){
        return visitor.visit(this);
    }
}
