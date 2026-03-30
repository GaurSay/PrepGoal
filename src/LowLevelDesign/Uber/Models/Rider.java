package LowLevelDesign.Uber.Models;

import lombok.Data;

@Data
public class Rider {
    String id;
    String name;

    public Rider(String id, String name) {
        this.id = id;
        this.name = name;
    }
}