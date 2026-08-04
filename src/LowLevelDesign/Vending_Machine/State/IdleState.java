package LowLevelDesign.Vending_Machine.State;

import LowLevelDesign.Vending_Machine.Enum.Coin;
import LowLevelDesign.Vending_Machine.VendingMachine;

public class IdleState implements State{

    private VendingMachine machine;

    public IdleState(VendingMachine machine){
        this.machine=machine;
    }

    @Override
    public void insertCoin(Coin coin){

        machine.getTransaction().insertCoin(coin);

        machine.setState(machine.getHasMoneyState());
    }

    @Override
    public void selectProduct(int shelfNo){

        System.out.println("Insert money first");
    }

    @Override
    public void dispense(){}

    @Override
    public void cancel(){}
}
