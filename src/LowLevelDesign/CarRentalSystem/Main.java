package LowLevelDesign.CarRentalSystem;

import LowLevelDesign.CarRentalSystem.Product.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //1. create users
        List<User> users = addUsers();

        //2. create vehicles
        List<Vehicle> vehicles = addVehicles();

        //3. create stores
        List<Store> stores = addStores(vehicles);

        VehicleRentalSystem rentalSystem = new VehicleRentalSystem(stores, users);

        //4. User comes
        User user = users.get(0);

        //5. user search store based on location
        Location location = new Location(403012, "Bangalore", "Karnataka", "India");


        Store store = rentalSystem.getStore(location);

        //6. get All vehicles you are interested in (based upon different filters)
        List<Vehicle> storeVehicles = store.getVehicles(VehicleType.CAR);

        //7.reserving the particular vehicle - take all details .. time and date everything
        Reservation reservation = store.createReservation(storeVehicles.get(0), users.get(0));

        //8. generate the bill
        Bill bill = new Bill(reservation);

        //9. make payment
        Payment payment = new Payment();
        payment.payBill(bill);

        //10. trip completed, submit the vehicle and close the reservation
        store.completeReservation(reservation.reservationId);






    }

    public static List<Vehicle> addVehicles(){

        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle vehicle1 = new Car();
        vehicle1.setVehicleID(1);
        vehicle1.setVehicleType(VehicleType.CAR);

        Vehicle vehicle2 = new Car();
        vehicle1.setVehicleID(2);
        vehicle1.setVehicleType(VehicleType.CAR);

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        return vehicles;
    }

    public static List<User> addUsers(){

        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setUserId(1);

        users.add(user1);
        return users;
    }

    public static List<Store> addStores(List<Vehicle> vehicles){

        List<Store> stores = new ArrayList<>();
        Store store1 = new Store();
        store1.storeId=1;
        store1.setVehicles(vehicles);

        stores.add(store1);
        return stores;
    }

}
