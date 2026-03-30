package LowLevelDesign.ParkingLot.Dto;

import LowLevelDesign.ParkingLot.Enum.VehicleType;
import lombok.Data;

@Data
public class GenerateTicketRequestDto {
    private String vehicleNumber;
    private Long gateId;
    private VehicleType vehicleType;
}
