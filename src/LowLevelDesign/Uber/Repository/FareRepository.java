package LowLevelDesign.Uber.Repository;

import LowLevelDesign.Uber.Models.Fare;

import java.util.HashMap;
import java.util.Map;

public class FareRepository {


    Map<String, Fare> fares = new HashMap<>();

    public void save(Fare fare) {
        fares.put(fare.getId(), fare);
    }
}
