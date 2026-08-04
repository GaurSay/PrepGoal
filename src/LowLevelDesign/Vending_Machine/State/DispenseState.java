package LowLevelDesign.Vending_Machine.State;

import LowLevelDesign.Vending_Machine.Enum.Coin;
import LowLevelDesign.Vending_Machine.Shelf;
import LowLevelDesign.Vending_Machine.VendingMachine;

public class DispenseState implements State{

    private VendingMachine machine;

    public DispenseState(VendingMachine machine){
        this.machine=machine;
    }

    @Override
    public void dispense(){

        Shelf shelf =
                machine.getSelectedShelf();

        shelf.dispense();

        int change =
                machine.getTransaction().getTotalPaid()
                        - shelf.getProduct().getPrice();

        System.out.println(
                "Dispensed : "
                        + shelf.getProduct().getName());

        System.out.println(
                "Change : "
                        + change);

        machine.getTransaction().reset();

        machine.setState(machine.getIdleState());
    }

    @Override
    public void insertCoin(Coin coin){}

    @Override
    public void selectProduct(int shelfNo){}

    @Override
    public void cancel(){}
}
