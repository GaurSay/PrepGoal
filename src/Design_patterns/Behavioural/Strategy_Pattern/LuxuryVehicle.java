package Design_patterns.Behavioural.Strategy_Pattern;

public class LuxuryVehicle extends Vehicle{

    LuxuryVehicle() {
        super(new SportsDriveStrategy());
    }
}
