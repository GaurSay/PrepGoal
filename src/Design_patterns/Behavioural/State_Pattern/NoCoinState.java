package Design_patterns.Behavioural.State_Pattern;

public class NoCoinState implements State{
    VendingMachine machine;

    public NoCoinState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin Inserted...");
        machine.setState(machine.getHasCoinState());
    }

    @Override
    public void selectProduct() {
        System.out.println("Please insert a coin first.");
    }
}
