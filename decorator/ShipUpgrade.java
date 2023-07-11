public abstract class ShipUpgrade implements ShipInterface{
    protected ShipInterface component;

    /**
     * Creates a basic, level-1 ship with the given name.
     *
     * @param name The name given to the ship by its player/owner.
     */
    public ShipUpgrade(ShipInterface component) {
        this.component = component;
    }

    public String getName() {
        return component.getName();
    }

    public int getTotalHitPoints() {
        return component.getTotalHitPoints();
    }

    public int getCurrentHitPoints() {
        return component.getCurrentHitPoints();
    }

    /**
     * Returns the amount of damage that this ship does when it attacks.
     *
     * @return The amount of damage this ship does when it attacks.
     */
    public int getDamage() {
        return component.getDamage();
    }

    /**
     * Called when another {@link SpaceShip} attacks this ship.
     *
     * @param attacker The attacking {@link SpaceShip}.  Used to determine the
     *                 amount of damage sustained.
     */
    public void underAttack(ShipInterface attacker) {
        component.underAttack(attacker);
    }

    /**
     * Returns true if the ship has been destroyed.
     *
     * @return True if the ship has been reduced to 0 hit points.
     */
    public boolean isDestroyed() {
        return component.isDestroyed();
    }

    /**
     * Deducts the specified number of hit points from the ship's current hit
     * points.
     *
     * @param amount The amount of hit points to deduct.
     */
    public void deductHitPoints(int amount) {
        component.deductHitPoints(amount);
    }
}
