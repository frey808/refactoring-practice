public class Refunding implements MachineStatus {
    public synchronized void insertCoin(VendingMachine.Coin coin) {
        System.out.println("Can't insert coins while refunding in progress.");
    }

    public synchronized void refund() {
        System.out.println("Stop mashing the button!");
    }

    public synchronized void dispenseProduct() {
        System.out.println("Can't purchase while refunding!");
    }
}