package LowLevelDesign.Vending_Machine;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<Integer,Shelf> shelves
            = new HashMap<>();

    public void addShelf(Shelf shelf){
        shelves.put(shelf.getShelfNo(),shelf);
    }

    public Shelf getShelf(int shelfNo){
        return shelves.get(shelfNo);
    }
}
