package Design_patterns.Behavioural.Strategy_Pattern;

public class NormalVehicle extends Vehicle{

    NormalVehicle() {
        super(new NormalDriveStrategy());
    }
}
