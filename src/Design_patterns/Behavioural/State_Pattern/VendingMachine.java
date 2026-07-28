package Design_patterns.Behavioural.State_Pattern;

import lombok.Getter;

public class VendingMachine {
    

    @Getter
    private final State noCoinState;
    @Getter
    private final State hasCoinState;
    @Getter
    private final State dispensingState;
    private State currentState;

    public VendingMachine() {
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        dispensingState = new DispensingState(this);

        this.currentState = noCoinState;
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void selectProduct() {
        currentState.selectProduct();
    }

    public void dispense() {
        System.out.println("Product dispensed.");
        setState(noCoinState);
    }
}
