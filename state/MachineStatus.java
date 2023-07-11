public interface MachineStatus {
    public VendingMachine vendingMachine = null;
    
    public void insertCoin(VendingMachine.Coin coin);
    public void refund();
    public void dispenseProduct();
}