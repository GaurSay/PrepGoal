package Design_patterns.Structural.Decorator_Pattern;

public class Main {

    public static void main(String[] args) {

        //This pattern helps to add more functionality to object without changing its structure
        BasePizza basePizza = new Mushroom(new VegDelight());
        System.out.println(basePizza.cost());
    }
}
