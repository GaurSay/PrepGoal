package LowLevelDesign.ParkingLot.Strategies;

import LowLevelDesign.ParkingLot.Enum.VehicleType;

public class DayWiseParkingFeesStrategy  implements  ParkingfeesStrategy{


    @Override
    public double calculateParkingFees(VehicleType vehicleType, long entryTime, long exitTime) {
        return 0;
    }
}
