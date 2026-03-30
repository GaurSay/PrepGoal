package LowLevelDesign.Uber.Models;

import lombok.Data;

import java.util.List;
@Data
public class Vehicle {
    String numberPlate;
    List<ProductType> supportedProducts;

    public Vehicle(String plate, List<ProductType> products) {
        this.numberPlate = plate;
        this.supportedProducts = products;
    }
}