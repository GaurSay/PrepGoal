package LowLevelDesign.Vending_Machine;

import lombok.Data;
import lombok.Getter;
@Data
public class Shelf {

    private final int shelfNo;

    @Getter
    private Product product;

    @Getter
    private int quantity;

    public Shelf(int shelfNo){
        this.shelfNo=shelfNo;
    }

    public void loadProduct(Product p,int qty){
        this.product=p;
        this.quantity=qty;
    }

    public boolean isAvailable(){
        return quantity>0;
    }

    public void dispense(){
        quantity--;
    }

}
