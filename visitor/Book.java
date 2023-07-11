/**
 * A book product.
 */
public class Book extends Product {
    private final String author;
    private final String publisher;
    private final int numberOfPages;

    public Book(String name, double price, int quantity, String author,
                String publisher, int numberOfPages) {
        super(name, price, quantity);
        this.author = author;
        this.publisher = publisher;
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
