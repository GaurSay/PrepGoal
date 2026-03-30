package Design_patterns.Behavioural.Strategy_Pattern;


public class NormalDriveStrategy implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("Normal Driving strategy !!!!");
    }
}
