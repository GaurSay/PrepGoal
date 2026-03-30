package LowLevelDesign.ParkingLot.Repositories;

import LowLevelDesign.ParkingLot.Models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {
    //Id ->  parkinglot
    Map<Long, ParkingLot> parkingLotMap = new HashMap<>();

    public ParkingLot getParkingLot(Long id){
        return parkingLotMap.get(id);
    }
}
