package LowLevelDesign.ParkingLot.Strategies;


import LowLevelDesign.ParkingLot.Enum.VehicleType;

import java.util.Map;

public class HourlyParkingFeesStrategy implements  ParkingfeesStrategy{

    // Event pricing: Higher per-hour rates
    private static final Map<VehicleType, Double> EVENT_HOURLY_RATES = Map.of(
            VehicleType.FOUR_WHEELER, 50.0,
            VehicleType.TWO_WHEELER, 30.0
    );

    public double calculateFee(VehicleType type, Long entryTime, Long exitTime) {
//        long durationMinutes = Duration.between(entryTime, exitTime).toMinutes();
//        long hours = (long) Math.ceil(durationMinutes / 60.0); // always round up to next hour

        double ratePerHour = EVENT_HOURLY_RATES.getOrDefault(type, 0.0);
//        ratePerHour = ratePerHour * hours;
        return ratePerHour;
    }

    @Override
    public double calculateParkingFees(VehicleType vehicleType, long entryTime, long exitTime) {
        return 0;
    }
}
