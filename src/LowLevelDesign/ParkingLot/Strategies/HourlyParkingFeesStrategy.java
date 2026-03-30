package LowLevelDesign.ParkingLot.Strategies;

import LowLevelDesign.CarRentalSystem.Product.VehicleType;

import java.util.Map;

public class HourlyParkingFeesStrategy implements  ParkingfeesStrategy{

    // Event pricing: Higher per-hour rates
    private static final Map<VehicleType, Double> EVENT_HOURLY_RATES = Map.of(
            VehicleType.CAR, 50.0,
            VehicleType.BIKE, 30.0
    );

    @Override
    public double calculateFee(VehicleType type, LocalDateTime entryTime, LocalDateTime exitTime) {
        long durationMinutes = Duration.between(entryTime, exitTime).toMinutes();
        long hours = (long) Math.ceil(durationMinutes / 60.0); // always round up to next hour

        double ratePerHour = EVENT_HOURLY_RATES.getOrDefault(type, 0.0);
        return ratePerHour * hours;
    }
    @Override
    public double calculateParkingFees(long entryTime, long exitTime) {
        return 0.00;
    }
}
