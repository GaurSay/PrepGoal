package Design_patterns.Behavioural.State_Pattern;

class HasCoinState implements State {

    private VendingMachine machine;

    public HasCoinState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin already inserted.");
    }

    @Override
    public void selectProduct() {
        System.out.println("Dispensing product...");
        machine.setState(machine.getDispensingState());
        machine.dispense();
    }
}
