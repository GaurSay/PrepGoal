package LowLevelDesign.ParkingLot.Models;

import LowLevelDesign.ParkingLot.Enum.ParkingSpotStatus;
import LowLevelDesign.ParkingLot.Enum.VehicleType;
import lombok.Data;
import lombok.Setter;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;


@Data
public class  ParkingSpot extends BaseClass{

    @Setter
    private ParkingSpotStatus parkingSpotStatus;
    private List<VehicleType> supportedVehicleTypes;
    private int number;

    private AtomicBoolean occupied = new AtomicBoolean(false);


    public boolean tryOccupy() {
        boolean status = occupied.compareAndSet(false, true);
        parkingSpotStatus = ParkingSpotStatus.OCCUPIED;
        return status;
    }

    public void vacate() {
        occupied.set(false);
        parkingSpotStatus = ParkingSpotStatus.AVAILABLE;
    }

    public boolean isOccupied() {
        return occupied.get();
    }

}

