package LowLevelDesign.ParkingLot.Models;

import LowLevelDesign.ParkingLot.Enum.GateType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gate extends BaseClass {
    private int number;
    private GateType gateType;
    private Operator operator;
    private Long parkingLotId;
//    private GateStatus gateStatus;

}
