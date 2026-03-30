package LowLevelDesign.Uber.Services;

import LowLevelDesign.Uber.Models.Driver;
import LowLevelDesign.Uber.Models.Location;
import LowLevelDesign.Uber.Repository.DriverRepository;
import LowLevelDesign.Uber.Strategy.IDriverMatchingStrategy;

import java.util.List;

public class DriverMatchingService {
    DriverRepository repo;
    IDriverMatchingStrategy strategy;

    public DriverMatchingService(DriverRepository repo, IDriverMatchingStrategy strategy) {
        this.repo = repo;
        this.strategy = strategy;
    }

    public Driver findDriver(Location src) {
        List<Driver> drivers = repo.getNearbyDrivers(src, 10);
        return strategy.findDriver(src, drivers);
    }
}
