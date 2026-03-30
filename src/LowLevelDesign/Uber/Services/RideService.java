package LowLevelDesign.Uber.Services;

import LowLevelDesign.Uber.Models.*;

import java.util.UUID;

public class RideService {
    DriverMatchingService matchingService;

    public RideService(DriverMatchingService matchingService) {
        this.matchingService = matchingService;
    }

    public Ride requestRide(Product product, Location src, Location dest, Rider rider) {
           Driver driver = matchingService.findDriver(src);

        if (driver == null) {
            throw new RuntimeException("No drivers available");
        }

        driver.markUnavailable();

        return new Ride(UUID.randomUUID().toString(),
                product, src, dest, rider, driver);
    }
}