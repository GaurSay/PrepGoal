package Design_patterns.Structural.Composite_Pattern;

public class Airconditioner implements SmartComponent{

    @Override
    public void switchOn() {
        System.out.println("Airconditioner switched on.");
    }

    @Override
    public void switchOff() {
        System.out.println("Airconditioner switched off");
    }
}
