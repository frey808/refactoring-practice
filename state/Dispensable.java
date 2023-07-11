public class Dispensable implements MachineStatus {
    private VendingMachine vendingMachine;

    public Dispensable(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    public synchronized void insertCoin(VendingMachine.Coin coin) {
        System.out.println("Can't insert more coins.");
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
        System.out.println("Dispensing delicious goodies!");
        vendingMachine.coins.clear();
        vendingMachine.machineStatus = vendingMachine.idle;
    }
}