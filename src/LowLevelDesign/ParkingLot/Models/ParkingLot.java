package LowLevelDesign.ParkingLot.Models;

import LowLevelDesign.ParkingLot.Enum.ParkingSpotStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

///Requirements :-
// 1. Operator should be able to generate the ticket.
// 2. Admin should be able to create a new Parking Lot.

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingLot extends BaseClass {

    private String name;
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private ParkingSpotStatus parkingLotStatus;
    private String address;

}
