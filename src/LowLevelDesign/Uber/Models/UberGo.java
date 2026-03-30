package LowLevelDesign.Uber.Models;

public class UberGo extends Product {
    public double getBaseRate() { return 40; }
    public double getPerKmRate() { return 8; }
    public double getPerMinRate() { return 1.5; }
}
