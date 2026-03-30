package Java_advanced;

import Threading.Car;
import Threading.Computer;

import java.util.LinkedList;
import java.util.List;


public class practice {

    public static void main(String[] args) {
//        Car myCar = Car.Builder.newInstance().setVehicleNumber(“1234”)
//        .setColor(“Black”).setModelName(“Swift”).setSeats(5).build();

//        Car mycar = Car.Builder.getInstance().setColor("Black").setModelName("swift").setSeats(5).build();

        Computer comp = new Computer("LenovoT1");
        System.out.println(comp.getId()+ " "+ comp.getModelName()+" "+comp.getDiskSize()+" "+comp.getRamSize());

        Computer comp2 = new Computer("LenovoT2",8, 128);
        System.out.println(comp2.getId()+ " "+ comp2.getModelName()+" "+comp2.getDiskSize()+" "+comp2.getRamSize());

//        Computer comp = new Computer();

//        Car mycar = Car.CarBuilder.getInstance().setColor("Black").setModelName("swift").setVehicleNumber("HR 15").setSeats(5).build();
//        System.out.println(mycar.getColor()+" "+ mycar.getModelName()+" "+ mycar.getVehicleNumber()+" "+mycar.getSeats());
//
//        Car mycar2 = Car.CarBuilder.getInstance().build();
//        System.out.println(mycar2.getColor()+" "+ mycar2.getModelName()+" "+ mycar2.getVehicleNumber()+" "+mycar2.getSeats());
//    }


     List<Integer> list = new LinkedList<>();
     list.add(1);
        System.out.println(list.get(0));
    }

}
