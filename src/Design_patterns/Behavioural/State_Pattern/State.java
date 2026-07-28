package Design_patterns.Behavioural.State_Pattern;
//Instead of writing a lot of if-else or
//switch statements based on the current state, we encapsulate each state into separate classes.


public interface State {
    void insertCoin();
    void selectProduct();
}
