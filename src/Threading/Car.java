package Threading;

public class Car {
//    Car myCar = Car.Builder.newInstance().setVehicleNumber(“1234”)
//        .setColor(“Black”).setModelName(“Swift”).setSeats(5).build();

    private String vehicleNumber;

    public Car(String modelName){

    Car c = new Car(""," ");
//    c.setModelName("modelName");

    }

    public Car(String vehicleNumber,String seats){

    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getColor() {
        return color;
    }

    public String getModelName() {
        return modelName;
    }

    public int getSeats() {
        return seats;
    }

    private String color;
    private String modelName;
    private int seats;



    public Car(CarBuilder carBuilder){
        this.seats = carBuilder.getSeats();
        this.color = carBuilder.getColor();
        this.vehicleNumber = carBuilder.getVehicleNumber();
        this.modelName = carBuilder.getModelName();
    }

    public static class CarBuilder {

         public String getVehicleNumber() {
             return vehicleNumber;
         }

         public String getColor() {
             return color;
         }

         public String getModelName() {
             return modelName;
         }

         public int getSeats() {
             return seats;
         }
         private String vehicleNumber;
        private String color;
        private String modelName;
        private int seats;

        public static CarBuilder getInstance() {
            return new CarBuilder();
        }


        public CarBuilder setVehicleNumber(String vehicleNumber) {
            this.vehicleNumber = vehicleNumber;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder setModelName(String modelName) {
            this.modelName = modelName;
            return this;
        }

        public CarBuilder setSeats(int seats) {
            this.seats = seats;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
}


}




