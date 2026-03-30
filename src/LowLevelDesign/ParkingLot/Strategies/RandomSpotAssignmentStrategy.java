package LowLevelDesign.ParkingLot.Strategies;

import LowLevelDesign.ParkingLot.Enum.VehicleType;
import LowLevelDesign.ParkingLot.Models.Gate;
import LowLevelDesign.ParkingLot.Models.ParkingSpot;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{
    @Override
    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate) {
        //Logic to assign the available slot.
//        ParkingLot parparkingLotRepositorykingLot = .getParkingLot(gate);
//        List<ParkingSpot> parkingSpots = parkingSpotRepository.getParkingSpots();
//
//        for(ParkingSpot parkingSpot : parkingSpots) {
//            if (parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE)) {
//                return parkingSpot;
//            }
//        }

        return null;
    }
}
