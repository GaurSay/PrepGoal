package LowLevelDesign.Vending_Machine;

import LowLevelDesign.Vending_Machine.Enum.Coin;
import LowLevelDesign.Vending_Machine.State.DispenseState;
import LowLevelDesign.Vending_Machine.State.HasMoneyState;
import LowLevelDesign.Vending_Machine.State.IdleState;
import LowLevelDesign.Vending_Machine.State.State;
import lombok.Data;

@Data
public class VendingMachine {

    private Inventory inventory;

    private Transaction transaction;

    private Shelf selectedShelf;

    private State idleState;
    private State hasMoneyState;
    private State dispenseState;

    private State currentState;

    public VendingMachine(){

        inventory=new Inventory();
        transaction=new Transaction();

        idleState=new IdleState(this);
        hasMoneyState=new HasMoneyState(this);
        dispenseState=new DispenseState(this);

        currentState=idleState;
    }

    public void insertCoin(Coin coin){
        currentState.insertCoin(coin);
    }

    public void selectProduct(int shelf){
        currentState.selectProduct(shelf);
    }

    public void dispense(){
        currentState.dispense();
    }

    public void cancel(){
        currentState.cancel();
    }

    public void setState(State state){
        currentState = state;
    }

    // getters and setters...
}
