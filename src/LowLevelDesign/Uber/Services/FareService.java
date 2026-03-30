package LowLevelDesign.Uber.Services;

import LowLevelDesign.Uber.Models.Fare;
import LowLevelDesign.Uber.Models.Location;
import LowLevelDesign.Uber.Models.Product;
import LowLevelDesign.Uber.Repository.FareRepository;
import LowLevelDesign.Uber.Strategy.DefaultPricingStrategy;
import LowLevelDesign.Uber.Strategy.IPricingStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class FareService {
    private FareRepository fareRepository;
    private IPricingStrategy pricingStrategy;

    public FareService() {
        this.fareRepository = new FareRepository();
        this.pricingStrategy = new DefaultPricingStrategy(); // can inject later
    }

    /**
     * Returns fare estimates for multiple products
     */
    public Map<Product, Double> getFareEstimates(Location src, Location dest, List<Product> products) {

        Map<Product, Double> estimates = new HashMap<>();

        for (Product product : products) {
            double fare = pricingStrategy.calculateFare(src, dest, product);
            estimates.put(product, fare);
        }

        return estimates;
    }

    /**
     * Creates and stores fare (with caching capability)
     */
    public Fare createFare(String riderId, Product product, Location src, Location dest) {

        double estimatedFare = pricingStrategy.calculateFare(src, dest, product);

        Fare fare = new Fare(
                UUID.randomUUID().toString(),
                product,
                src,
                dest,
                estimatedFare
        );

        // Save in repository (can be DB/Cache)
        fareRepository.save(fare);

        return fare;
    }
}