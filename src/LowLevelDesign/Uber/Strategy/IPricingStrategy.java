package LowLevelDesign.Uber.Strategy;

import LowLevelDesign.Uber.Models.Location;
import LowLevelDesign.Uber.Models.Product;

public interface IPricingStrategy {

    double calculateFare(Location src, Location dest, Product product);
}
