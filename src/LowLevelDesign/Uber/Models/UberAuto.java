package LowLevelDesign.Uber.Models;

public class UberAuto extends Product {
    public double getBaseRate() { return 30; }
    public double getPerKmRate() { return 6; }
    public double getPerMinRate() { return 1; }
}
