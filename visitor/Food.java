/**
 * A food product.
 */
public class Food extends Product {
    private final int calories;

    public Food(String name, double price, int quantity, int calories) {
        super(name, price, quantity);

        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }
}
