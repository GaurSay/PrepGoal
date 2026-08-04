package LowLevelDesign.Vending_Machine;

import LowLevelDesign.Vending_Machine.Enum.Coin;
import LowLevelDesign.Vending_Machine.Enum.Note;

public class Transaction {

    private int totalPaid;

    public void insertCoin(Coin coin){
        totalPaid += coin.getValue();
    }

    public void insertNote(Note note){
        totalPaid += note.getValue();
    }

    public int getTotalPaid(){
        return totalPaid;
    }

    public void reset(){
        totalPaid=0;
    }
}
