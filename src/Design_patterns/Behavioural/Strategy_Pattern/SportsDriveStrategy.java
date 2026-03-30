package Design_patterns.Behavioural.Strategy_Pattern;

public class SportsDriveStrategy implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("Sports Driving strategy !!!!");
    }
}
