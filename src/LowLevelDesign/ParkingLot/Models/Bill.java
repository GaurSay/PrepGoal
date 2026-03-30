package LowLevelDesign.ParkingLot.Models;

import LowLevelDesign.ParkingLot.Enum.BillStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill extends BaseClass{

    private Ticket ticket;
    private Date exitTime;
    private Double amount;
    private Operator operator;
    private Gate gate;
    private List<Payment> payments;
    private BillStatus billStatus = BillStatus.UNPAID;


}
