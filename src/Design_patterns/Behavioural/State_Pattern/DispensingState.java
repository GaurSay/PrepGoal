package Design_patterns.Behavioural.State_Pattern;

class DispensingState implements State {

    private VendingMachine machine;

    public DispensingState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Please wait. Dispensing in progress.");
    }

    @Override
    public void selectProduct() {
        System.out.println("Already dispensing.");
    }
}
