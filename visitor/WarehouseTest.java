import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class WarehouseTest {
    // books
    private static final Book IT = new Book("It", 9.99, 4, "Stephen King",
            "Simon and Schuster", 1237);
    private static final Book STRANGE_WEATHER = new Book("Strange Weather",
            7.99, 74, "Joe Hill", "Harper Collins", 837);
    // food
    private static final Food FRENCH_FRIES = new Food("French Fries", 2.99,
            37, 800);
    private static final Food FRIED_CHICKEN = new Food("Fried Chicken",
            6.99, 4, 1800);
    private static final Food WAFFLES = new Food("Waffles", 9.99, 25, 600);
    // toys
    private static final Toy HULKBUSTER = new Toy("LEGO Hulkbuster",
            120.00, 5, 16, false);
    private static final Toy SLINKY = new Toy("Slinky", 1.00, 4, 0,
            false);
    private static final Toy RC_CAR = new Toy("RC Car", 50.00, 12, 12,
                                             true);
    //movies
    private static final Movie ALIENS = new Movie("Aliens", 9.99, 121,
            "James Cameron", Movie.Rating.R);
    private static final Movie MOANA = new Movie("Moana", 19.99, 223,
            "John Musker, Ron Clements", Movie.Rating.PG);
    private static final Movie STAR_WARS_TFA = new Movie(
            "Star Wars: The Force Awakens", 19.99, 3, "JJ Abrams",
            Movie.Rating.PG_13);


    private Warehouse warehouse;

    /**
     * Populates a warehouse with a few products
     */
    @Before
    public void runBeforeTests() {
        warehouse = new Warehouse();
        // books
        warehouse.addProduct(IT);
        warehouse.addProduct(STRANGE_WEATHER);
        // food
        warehouse.addProduct(FRENCH_FRIES);
        warehouse.addProduct(FRIED_CHICKEN);
        warehouse.addProduct(WAFFLES);
        // toys
        warehouse.addProduct(HULKBUSTER);
        warehouse.addProduct(SLINKY);
        warehouse.addProduct(RC_CAR);
        //movies
        warehouse.addProduct(ALIENS);
        warehouse.addProduct(MOANA);
        warehouse.addProduct(STAR_WARS_TFA);

    }

    @Test
    public void getTotalInventoryValue() {
        double expected = 7950.09;
        double actual = warehouse.getTotalInventoryValue();
        assertEquals("Total inventory value is wrong!", expected, actual);
    }

    @Test
    public void getProductsToReorder() {
        Collection<Product> expected = new HashSet<>();
        expected.add(IT);
        expected.add(FRIED_CHICKEN);
        expected.add(SLINKY);
        expected.add(STAR_WARS_TFA);

        Collection<Product> actual = warehouse.getProductsToReorder();

        assertNotNull("Reorder should not be null!", actual);
        assertEquals("Wrong number of products!", expected.size(),
                actual.size());
        assertTrue("Wrong products!",
                actual.containsAll(expected));
    }

    @Test
    public void getMoviesByDirector() {
        List<Movie> expected = new ArrayList<>(1);
        expected.add(ALIENS);

        List<Movie> actual =
                warehouse.getMoviesByDirector("James Cameron");

        assertNotNull("Should be at least one movie!", actual);
        assertEquals("Wrong number of movies!", expected.size(),
                actual.size());
        assertTrue("Wrong movies!", actual.containsAll(expected));
    }

    @Test
    public void getToysForAge() {
        List<Toy> expected = new ArrayList<>(2);
        expected.add(HULKBUSTER);
        expected.add(RC_CAR);

        List<Toy> actual = warehouse.getToysSuitableForAge(10);

        assertNotNull("Should be at least two toys!", actual);
        assertEquals("Wrong number of toys!", expected.size(),
                actual.size());
        assertTrue("Wrong toys!", actual.containsAll(expected));
    }

    @Test
    public void visitorTotalInventoryValue() {
        double expected = 7950.09;
        double actual = warehouse.visitorTotalInventoryValue();
        assertEquals("Total inventory value is wrong!", expected, actual);
    }

    @Test
    public void visitorProductsToReorder() {
        Collection<Product> expected = new HashSet<>();
        expected.add(IT);
        expected.add(FRIED_CHICKEN);
        expected.add(SLINKY);
        expected.add(STAR_WARS_TFA);

        Collection<Product> actual = warehouse.visitorProductsToReorder();

        assertNotNull("Reorder should not be null!", actual);
        assertEquals("Wrong number of products!", expected.size(),
                actual.size());
        assertTrue("Wrong products!",
                actual.containsAll(expected));
    }

    @Test
    public void visitorMoviesByDirector() {
        List<Movie> expected = new ArrayList<>(1);
        expected.add(ALIENS);

        List<Movie> actual =
                warehouse.visitorMoviesByDirector("James Cameron");

        assertNotNull("Should be at least one movie!", actual);
        assertEquals("Wrong number of movies!", expected.size(),
                actual.size());
        assertTrue("Wrong movies!", actual.containsAll(expected));
    }

    @Test
    public void visitorToysForAge() {
        List<Toy> expected = new ArrayList<>(2);
        expected.add(HULKBUSTER);
        expected.add(RC_CAR);

        List<Toy> actual = warehouse.visitorToysSuitableForAge(10);

        assertNotNull("Should be at least two toys!", actual);
        assertEquals("Wrong number of toys!", expected.size(),
                actual.size());
        assertTrue("Wrong toys!", actual.containsAll(expected));
    }

    @Test
    public void visitorProductsInPriceRange() {
        List<Product> expected = new ArrayList<>(1);
        expected.add(RC_CAR);

        List<Product> actual = warehouse.visitorProductsInPriceRange(45, 55);

        assertNotNull("Should not be null!", actual);
        assertEquals("Wrong number of products!", expected.size(),
                actual.size());
        assertTrue("Wrong toys!", actual.containsAll(expected));
    }

    @Test
    public void visitorProductsQuantityAbove() {
        List<Product> expected = new ArrayList<>(1);
        expected.add(MOANA);

        List<Product> actual = warehouse.visitorProductsQuantityAbove(200);

        assertNotNull("Should not be null!", actual);
        assertEquals("Wrong number of products!", expected.size(),
                actual.size());
        assertTrue("Wrong toys!", actual.containsAll(expected));
    }
}
