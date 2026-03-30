package LowLevelDesign.ParkingLot.Strategies;

import LowLevelDesign.ParkingLot.Enum.ParkingSpotStatus;
import LowLevelDesign.ParkingLot.Enum.VehicleType;
import LowLevelDesign.ParkingLot.Models.Gate;
import LowLevelDesign.ParkingLot.Models.ParkingFloor;
import LowLevelDesign.ParkingLot.Models.ParkingLot;
import LowLevelDesign.ParkingLot.Models.ParkingSpot;
import LowLevelDesign.ParkingLot.Repositories.ParkingLotRepository;

import java.util.Comparator;

public class NearestSpotAssignmentStrategy implements SpotAssignmentStrategy{

    ParkingLotRepository parkingLotRepository =  new ParkingLotRepository();

    @Override
    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate) {

        if (gate == null) {
            throw new IllegalArgumentException("Invalid gate or floor");
        }
        ParkingLot parkingLot = parkingLotRepository.getParkingLot(gate.getParkingLotId());

        ParkingSpot bestSpot = null;
        int minDistance = Integer.MAX_VALUE;

        for (ParkingFloor floor : parkingLot.getParkingFloors()) {

            ParkingSpot candidate = getNearestAvailableSpotOnFloor(floor, vehicleType);

            if (candidate != null) {

                int distance = calculateDistance(gate, floor, candidate);

                if (distance < minDistance) {
                    minDistance = distance;
                    bestSpot = candidate;
                }
            }
        }

        return bestSpot;
    }

    private ParkingSpot getNearestAvailableSpotOnFloor(ParkingFloor floor, VehicleType vehicleType) {

        if (floor == null) {
            return null;
        }

        return floor.getParkingSpots().stream()
                .filter(spot -> spot.getParkingSpotStatus() == ParkingSpotStatus.AVAILABLE)
                .filter(spot -> supportsVehicleType(spot, vehicleType))
                .min(Comparator.comparing(ParkingSpot::getId)) // replace with real distance if available
                .orElse(null);
    }

    private boolean supportsVehicleType(ParkingSpot spot, VehicleType vehicleType) {
        return spot.getSupportedVehicleTypes().contains(vehicleType);
    }

    private int calculateDistance(Gate gate, ParkingFloor floor, ParkingSpot spot) {

        // Basic version (interview-safe):
        // assume floor difference matters more than spot position
        int floorDistance = Math.abs(floor.getNumber());

        // optional: add intra-floor distance
        int spotDistance = spot.getId().intValue(); // placeholder

        return floorDistance * 1000 + spotDistance;
    }
}