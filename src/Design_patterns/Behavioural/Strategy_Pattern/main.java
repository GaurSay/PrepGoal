package Design_patterns.Behavioural.Strategy_Pattern;

public class main {

    public static void main(String args[])
    {
        NormalVehicle normalVehicle = new NormalVehicle();
        LuxuryVehicle luxuryVehicle = new LuxuryVehicle();

        normalVehicle.drive();
        luxuryVehicle.drive();
    }
}
