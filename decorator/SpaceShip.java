public class SpaceShip implements ShipInterface{
    private String name;
    private int totalHitPoints;
    private int currentHitPoints;
    private int damage;

    /**
     * Creates a basic, level-1 ship with the given name.
     *
     * @param name The name given to the ship by its player/owner.
     */
    public SpaceShip(String name) {
        this.name = name;
        totalHitPoints = 1000;
        damage = 50;
        currentHitPoints = totalHitPoints;
    }

    public String getName() {
        return name;
    }

    public int getTotalHitPoints() {
        return totalHitPoints;
    }

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    /**
     * Returns the amount of damage that this ship does when it attacks.
     *
     * @return The amount of damage this ship does when it attacks.
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Called when another {@link SpaceShip} attacks this ship.
     *
     * @param attacker The attacking {@link SpaceShip}.  Used to determine the
     *                 amount of damage sustained.
     */
    public void underAttack(ShipInterface attacker) {
        int damage = attacker.getDamage();
        deductHitPoints(damage);
    }

    /**
     * Returns true if the ship has been destroyed.
     *
     * @return True if the ship has been reduced to 0 hit points.
     */
    public boolean isDestroyed() {
        return currentHitPoints <= 0;
    }

    /**
     * Deducts the specified number of hit points from the ship's current hit
     * points.
     *
     * @param amount The amount of hit points to deduct.
     */
    public void deductHitPoints(int amount) {
        currentHitPoints = currentHitPoints - amount;
    }
}
