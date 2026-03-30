package LowLevelDesign.Uber;

import LowLevelDesign.Uber.Models.*;
import LowLevelDesign.Uber.Repository.DriverRepository;
import LowLevelDesign.Uber.Services.DriverMatchingService;
import LowLevelDesign.Uber.Services.FareService;
import LowLevelDesign.Uber.Services.RideService;
import LowLevelDesign.Uber.Strategy.IDriverMatchingStrategy;
import LowLevelDesign.Uber.Strategy.NearestDriverStrategy;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // SETUP REPOSITORIES
        // =========================
        DriverRepository driverRepo = new DriverRepository();

        // =========================
        // CREATE DRIVERS
        // =========================
        Vehicle v1 = new Vehicle("KA01AB1234",
                List.of(ProductType.UBER_GO, ProductType.UBER_X));

        Vehicle v2 = new Vehicle("KA02CD5678",
                List.of(ProductType.UBER_AUTO));

        Driver d1 = new Driver("D1", "Ramesh",
                new Location(12.9716, 77.5946), v1, 4.5);

        Driver d2 = new Driver("D2", "Suresh",
                new Location(12.9611, 77.6387), v2, 4.8);

        driverRepo.save(d1);
        driverRepo.save(d2);

        // =========================
        // STRATEGIES
        // =========================
        IDriverMatchingStrategy matchingStrategy = new NearestDriverStrategy();

        // =========================
        // SERVICES
        // =========================
        DriverMatchingService matchingService =
                new DriverMatchingService(driverRepo, matchingStrategy);

        RideService rideService = new RideService(matchingService);

        FareService fareService = new FareService();

        // =========================
        // RIDER + LOCATIONS
        // =========================
        Rider rider = new Rider("R1", "Shubham");

        Location src = new Location(12.9716, 77.5946);
        Location dest = new Location(12.9352, 77.6245);

        // =========================
        // AVAILABLE PRODUCTS
        // =========================
        List<Product> products = List.of(
                new UberGo(),
                new UberX(),
                new UberAuto()
        );

        // =========================
        // STEP 1: GET FARE ESTIMATES
        // =========================
        Map<Product, Double> estimates =
                fareService.getFareEstimates(src, dest, products);

        System.out.println("=== Fare Estimates ===");
        for (Map.Entry<Product, Double> entry : estimates.entrySet()) {
            System.out.println(entry.getKey().getClass().getSimpleName()
                    + " -> ₹" + entry.getValue());
        }

        // =========================
        // STEP 2: SELECT PRODUCT (cheapest)
        // =========================
        Product selectedProduct = estimates.entrySet()
                .stream()
                .min(Comparator.comparing(Map.Entry::getValue))
                .get()
                .getKey();

        System.out.println("\nSelected Product: "
                + selectedProduct.getClass().getSimpleName());

        // =========================
        // STEP 3: CREATE FARE
        // =========================
        Fare fare = fareService.createFare(
                rider.getId(),
                selectedProduct,
                src,
                dest
        );

        System.out.println("Final Fare Created: ₹" + fare.getEstimatedFare());

        // =========================
        // STEP 4: REQUEST RIDE
        // =========================
        Ride ride = rideService.requestRide(
                selectedProduct,
                src,
                dest,
                rider
        );

        // =========================
        // OUTPUT
        // =========================
        System.out.println("\n=== Ride Details ===");
        System.out.println("Ride ID: " + ride.getId());
        System.out.println("Driver: " + ride.getDriver().getName());
        System.out.println("Vehicle: " + ride.getVehicle().getNumberPlate());
        System.out.println("Status: " + ride.getStatus());
    }
}
