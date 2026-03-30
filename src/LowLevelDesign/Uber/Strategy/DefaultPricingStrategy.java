package LowLevelDesign.Uber.Strategy;

import LowLevelDesign.Uber.Models.Location;
import LowLevelDesign.Uber.Models.Product;

public class DefaultPricingStrategy implements IPricingStrategy {
    public double calculateFare(Location src, Location dest, Product product) {
        double distance = src.distanceTo(dest);
        double time = distance * 2; // assume

        return product.getBaseRate()
                + distance * product.getPerKmRate()
                + time * product.getPerMinRate();
    }
}
