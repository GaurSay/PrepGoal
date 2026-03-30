package LowLevelDesign.Uber.Models;

public abstract class Product {
    String id;
    ProductType type;

    public abstract double getBaseRate();

    public abstract double getPerKmRate();

    public abstract double getPerMinRate();
}