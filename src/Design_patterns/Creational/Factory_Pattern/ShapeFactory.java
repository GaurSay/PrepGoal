package Design_patterns.Creational.Factory_Pattern;

public class ShapeFactory {

        Shape shape;

        public Shape getShape(String shape){

            switch (shape){
                case "CIRCLE" :
                    return new Circle();
                case "RECTANGLE" :
                    return new Rectangle();
                default:
                    return null;
            }
        }
}
