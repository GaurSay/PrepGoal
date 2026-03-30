package LowLevelDesign.Uber.Models;

public class UberX extends Product {
    public double getBaseRate() { return 50; }
    public double getPerKmRate() { return 10; }
    public double getPerMinRate() { return 2; }
}
