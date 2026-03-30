package LowLevelDesign.ParkingLot.Repositories;

import LowLevelDesign.ParkingLot.Models.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {
    private Map<Long, Gate> gates = new HashMap<>();


    public Gate findById(Long id){
        return gates.get(id);
    }
}
