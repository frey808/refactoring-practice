public class Idle implements MachineStatus {
    private VendingMachine vendingMachine;

    public Idle(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    public synchronized void insertCoin(VendingMachine.Coin coin) {
        double amountAlreadyInserted = vendingMachine.calculateMoneyInserted();
        if(amountAlreadyInserted + coin.amount() > 1.00) {
            System.out.println("Exact change only.");
        } else {
            vendingMachine.coins.add(coin);
            if(vendingMachine.calculateMoneyInserted() == 1.00) {
                vendingMachine.machineStatus = vendingMachine.dispensable;
            }
        }
    }

    public synchronized void refund() {
        vendingMachine.machineStatus = vendingMachine.refunding;
        for(VendingMachine.Coin coin : vendingMachine.coins) {
            System.out.println("A " + coin.toString() + " pops out. *clink*");
            // realistic simulation!
            try {
                wait(vendingMachine.refundDelay);
            } catch (InterruptedException e) {
                // ignore
            }
        }
        vendingMachine.coins.clear();
        vendingMachine.machineStatus = vendingMachine.idle;
    }

    public synchronized void dispenseProduct() {
        System.out.println("Insufficient funds!");
    }
}