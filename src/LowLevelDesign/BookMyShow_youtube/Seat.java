package LowLevelDesign.BookMyShow_youtube;


import LowLevelDesign.BMS.Models.SeatStatus;
import LowLevelDesign.BMS.Models.SeatType;
import LowLevelDesign.BookMyShow_youtube.Enums.SeatCategory;
import lombok.Data;

@Data
public class Seat {

    private String name;

//    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    private int row;

//    @Column(name = "col")
    private int column;

//    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;

    public void setSeatId(int i) {
    }

    public void setSeatCategory(SeatCategory seatCategory) {
    }
}
