public interface ShipInterface {

    public String name = null;
    public int totalHitPoints = 0;
    public int currentHitPoints = 0;
    public int damage = 0;

    public String getName();
    public int getTotalHitPoints();
    public int getCurrentHitPoints();
    public int getDamage();
    public void underAttack(ShipInterface attacker);
    public boolean isDestroyed();
    public void deductHitPoints(int amount);
}
