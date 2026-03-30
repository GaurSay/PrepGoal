package LowLevelDesign.ParkingLot.Models;

import LowLevelDesign.ParkingLot.Enum.ParkingSpotStatus;
import lombok.Data;

import java.util.List;

@Data
public class ParkingFloor extends BaseClass{
    private int number;
    
    private List<ParkingSpot> parkingSpots;

    private ParkingSpotStatus parkingFloorStatus;

}
