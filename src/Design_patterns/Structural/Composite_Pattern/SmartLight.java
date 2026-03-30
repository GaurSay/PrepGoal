package Design_patterns.Structural.Composite_Pattern;

public class SmartLight implements SmartComponent{


    @Override
    public void switchOn() {
        System.out.println("SmartLight switched on.");
    }

    @Override
    public void switchOff() {
        System.out.println("SmartLight switched off");
    }
}
