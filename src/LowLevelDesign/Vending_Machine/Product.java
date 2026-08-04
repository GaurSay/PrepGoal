package LowLevelDesign.Vending_Machine;

import lombok.Getter;

public class Product {

    private final String id;
    @Getter
    private final String name;
    @Getter
    private final int price;

    public Product(String id,
                   String name,
                   int price){

        this.id=id;
        this.name=name;
        this.price=price;
    }

}
