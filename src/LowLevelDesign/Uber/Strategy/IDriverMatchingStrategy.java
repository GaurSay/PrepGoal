package LowLevelDesign.Uber.Strategy;

import LowLevelDesign.Uber.Models.Driver;
import LowLevelDesign.Uber.Models.Location;

import java.util.List;

public interface IDriverMatchingStrategy {
    Driver findDriver(Location src, List<Driver> drivers);
}
