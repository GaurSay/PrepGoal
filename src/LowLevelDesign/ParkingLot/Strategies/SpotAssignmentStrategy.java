package LowLevelDesign.ParkingLot.Strategies;

import LowLevelDesign.ParkingLot.Enum.VehicleType;
import LowLevelDesign.ParkingLot.Models.Gate;
import LowLevelDesign.ParkingLot.Models.ParkingSpot;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(VehicleType vehicleType, Gate gate);
}
