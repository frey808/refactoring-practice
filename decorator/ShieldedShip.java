/**
 * One of three upgraded ships that players can choose when they reach level
 * 10.  This ship is surrounded by an energy shield that absorbs all incoming
 * damage until the shield is depleted.
 *
 * Created by Bobby on 6/30/2017.
 */
public class ShieldedShip extends ShipUpgrade {

    private int shieldHitPoints;

    /**
     * Creates a basic, level-1 ship with the given name.
     *
     * @param name The name given to the ship by its player/owner.
     */
    public ShieldedShip(ShipInterface component) {
        super(component);
        shieldHitPoints = 500;
    }

    /**
     * This craft has a shield that absorbs all incoming damage until the
     * shield is depleted.
     *
     * @param amount The amount of hit points to deduct.
     */
    @Override
    public void deductHitPoints(int amount) {
        if(shieldHitPoints > amount) {
            // the shield absorbs all damage
            shieldHitPoints = shieldHitPoints - amount;
        }
        else if(shieldHitPoints > 0) {
            // the shield absorbs some damage and is depleted.  the remaining
            // damage is dealt to the ship itself.
            component.deductHitPoints(amount - shieldHitPoints);
            shieldHitPoints = 0;
        }
        else {
            // the shield is gone; full damage is dealt
            component.deductHitPoints(amount);
        }
    }
}
