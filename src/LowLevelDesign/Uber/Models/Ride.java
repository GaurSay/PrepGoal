package LowLevelDesign.Uber.Models;


import lombok.Data;

@Data
public class Ride {
    String id;
    Product product;
    Location src;
    Location dest;
    Rider rider;
    Driver driver;
    Vehicle vehicle;
    RideStatus status;

    public Ride(String id, Product product, Location src, Location dest,
                Rider rider, Driver driver) {
        this.id = id;
        this.product = product;
        this.src = src;
        this.dest = dest;
        this.rider = rider;
        this.driver = driver;
        this.vehicle = driver.vehicle;
        this.status = RideStatus.REQUESTED;
    }
}