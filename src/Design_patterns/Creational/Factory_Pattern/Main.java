package Design_patterns.Creational.Factory_Pattern;

public class Main {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        shapeFactory.getShape("CIRCLE").draw();

        // Abstract Factory - factory of factory
        // Group objects together in diff category
        // ex - ordinary factory - tata,toyota, hyundai ...
        // luxury vehicle - mercedes, bmw, audi
    }
}
