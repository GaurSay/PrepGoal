package LowLevelDesign.Uber.Repository;

import LowLevelDesign.Uber.Models.Driver;
import LowLevelDesign.Uber.Models.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverRepository {
    Map<String, Driver> drivers = new HashMap<>();

    public void save(Driver driver) {
        drivers.put(driver.getId(), driver);
    }

    public List<Driver> getNearbyDrivers(Location src, double radius) {
        List<Driver> result = new ArrayList<>();
        for (Driver d : drivers.values()) {
            if (d.isAvailable() && d.getCurrLocation().distanceTo(src) <= radius) {
                result.add(d);
            }
        }
        return result;
    }
}
