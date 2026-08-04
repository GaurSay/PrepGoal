package LowLevelDesign.Vending_Machine.State;

import LowLevelDesign.Vending_Machine.Enum.Coin;
import LowLevelDesign.Vending_Machine.Shelf;
import LowLevelDesign.Vending_Machine.VendingMachine;

public class HasMoneyState implements State {

    private VendingMachine machine;

    public HasMoneyState(VendingMachine machine){
        this.machine=machine;
    }

    @Override
    public void insertCoin(Coin coin){

        machine.getTransaction().insertCoin(coin);
    }

    @Override
    public void selectProduct(int shelfNo){

        Shelf shelf =
                machine.getInventory().getShelf(shelfNo);

        if(!shelf.isAvailable()){
            throw new RuntimeException("Out of Stock");
        }

        if(machine.getTransaction().getTotalPaid()
                < shelf.getProduct().getPrice()){

            throw new RuntimeException("Insufficient Money");
        }

        machine.setSelectedShelf(shelf);

        machine.setState(machine.getDispenseState());
    }

    @Override
    public void dispense(){}

    @Override
    public void cancel(){

        System.out.println(
                "Returned "
                        + machine.getTransaction().getTotalPaid());

        machine.getTransaction().reset();

        machine.setState(machine.getIdleState());
    }
}
