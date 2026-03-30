package Design_patterns.Structural.Composite_Pattern;

import java.util.ArrayList;
import java.util.List;

public class CompositeSmartComponent implements SmartComponent{
    private List<SmartComponent> components = new ArrayList<>();

    @Override
    public void switchOn() {
        for(SmartComponent sm : components){
            sm.switchOn();
        }
    }

    @Override
    public void switchOff() {
        for(SmartComponent sm : components){
            sm.switchOff();
        }
    }

    public void addComponent(SmartComponent sm) {
        components.add(sm);
    }

    public void removeComponent(SmartComponent sm) {
        components.remove(sm);
    }
}
