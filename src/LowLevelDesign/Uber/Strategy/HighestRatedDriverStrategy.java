package LowLevelDesign.Uber.Strategy;

import LowLevelDesign.Uber.Models.Driver;
import LowLevelDesign.Uber.Models.Location;

import java.util.Comparator;
import java.util.List;

public class HighestRatedDriverStrategy implements IDriverMatchingStrategy {

    public Driver findDriver(Location src, List<Driver> drivers) {
        //drivers.stream().max(Comparator.comparing(Driver::getRating)).orElse(null);
        return drivers.stream()
                .max(Comparator.comparing(d -> d.getRating()))
                .orElse(null);
    }
}