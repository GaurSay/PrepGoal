package LowLevelDesign.Uber.Models;

import lombok.Data;

import java.util.concurrent.atomic.AtomicBoolean;


@Data
public class Driver {
    String id;
    String name;
    Location currLocation;
    AtomicBoolean available;
    Vehicle vehicle;
    double rating;

    public Driver(String id, String name, Location loc, Vehicle vehicle, double rating) {
        this.id = id;
        this.name = name;
        this.currLocation = loc;
        this.vehicle = vehicle;
        this.rating = rating;
        this.available = new AtomicBoolean(true);
    }

    public boolean isAvailable() {
        return available.get();
    }

    public void markUnavailable() {
        available.set(false);
    }

    public void markAvailable() {
        available.set(true);
    }
}
