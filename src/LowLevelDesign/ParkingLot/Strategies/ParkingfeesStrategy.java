package LowLevelDesign.ParkingLot.Strategies;

import LowLevelDesign.ParkingLot.Enum.VehicleType;

public interface ParkingfeesStrategy {

    public double calculateParkingFees(VehicleType vehicleType,long entryTime, long exitTime);
}
