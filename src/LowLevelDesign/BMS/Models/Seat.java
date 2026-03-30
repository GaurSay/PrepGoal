package LowLevelDesign.BMS.Models;
import lombok.*;

@Data
@Builder
public class Seat extends BaseModel {

    private SeatType seatType;
    private String name;
    private int row;
    private int col;
}
