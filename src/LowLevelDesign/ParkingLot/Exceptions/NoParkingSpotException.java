package LowLevelDesign.ParkingLot.Exceptions;

public class NoParkingSpotException extends RuntimeException {
    public NoParkingSpotException(String message) {
        super(message);
    }
}
