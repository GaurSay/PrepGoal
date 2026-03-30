package LowLevelDesign.Uber.Models;

import lombok.Data;

import java.time.Instant;

@Data
public class Fare {
    String id;
    Product product;
    Location src;
    Location dest;
    double estimatedFare;
    Instant createdAt;

    public Fare(String id, Product product, Location src, Location dest, double fare) {
        this.id = id;
        this.product = product;
        this.src = src;
        this.dest = dest;
        this.estimatedFare = fare;
        this.createdAt = Instant.now();
    }
}
