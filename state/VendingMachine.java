import java.util.ArrayList;
import java.util.List;

/**
 * Created by robertstjacquesjr on 2/22/17.
 */

public class VendingMachine {

    public enum Coin {
        NICKEL (0.05),
        DIME (0.10),
        QUARTER (0.25),
        FIFTY_CENT_PIECE (0.5),
        DOLLAR (1.00);

        private double amount;

        Coin(double amount) {
            this.amount = amount;
        }

        public double amount() {
            return amount;
        }
    }

    protected MachineStatus machineStatus;
    protected Idle idle;
    protected Dispensable dispensable;
    protected Refunding refunding;
    protected List<Coin> coins;

    protected final long refundDelay;

    public VendingMachine() {
        this(500);
    }

    VendingMachine(long refundDelay) {
        coins = new ArrayList<>();
        idle = new Idle(this);
        dispensable = new Dispensable(this);
        refunding = new Refunding();
        machineStatus = idle;

        this.refundDelay = refundDelay;
    }

    public void insertCoin(Coin coin) {
        machineStatus.insertCoin(coin);
    }

    public void refund() {
        machineStatus.refund();
    }

    public void dispenseProduct() {
        machineStatus.dispenseProduct();
    }

    protected double calculateMoneyInserted() {
        double amount = 0.0;

        for(Coin coin : coins) {
            amount += coin.amount();
        }
        return amount;
    }
}