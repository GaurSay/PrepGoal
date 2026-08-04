package LowLevelDesign.Vending_Machine.State;

import LowLevelDesign.Vending_Machine.Enum.Coin;

public interface State {

    void insertCoin(Coin coin);

    void selectProduct(int shelfNo);

    void dispense();

    void cancel();
}
