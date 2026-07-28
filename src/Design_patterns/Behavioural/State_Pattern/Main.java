package Design_patterns.Behavioural.State_Pattern;

public class Main {

    public static void main(String[] args) {

        VendingMachine machine = new VendingMachine();

        machine.selectProduct();

        machine.insertCoin();

        machine.insertCoin();

        machine.selectProduct();

        machine.insertCoin();
    }
}
