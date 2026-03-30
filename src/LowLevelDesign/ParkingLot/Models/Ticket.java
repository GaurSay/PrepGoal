package LowLevelDesign.ParkingLot.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket extends BaseClass{

    private Date entryTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private Operator operator;

    private ParkingLot parkingLot;
    private Gate gate;
    private String ownerName;
}
