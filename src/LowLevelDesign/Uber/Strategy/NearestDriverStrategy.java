package LowLevelDesign.Uber.Strategy;

import LowLevelDesign.Uber.Models.Driver;
import LowLevelDesign.Uber.Models.Location;

import java.util.Comparator;
import java.util.List;

public class NearestDriverStrategy implements IDriverMatchingStrategy {

    public Driver findDriver(Location src, List<Driver> drivers) {
        return drivers.stream()
                .min(Comparator.comparing(d -> d.getCurrLocation().distanceTo(src)))
                .orElse(null);
    }
}