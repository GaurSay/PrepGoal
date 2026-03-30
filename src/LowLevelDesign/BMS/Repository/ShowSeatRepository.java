package LowLevelDesign.BMS.Repository;

import LowLevelDesign.BMS.Models.ShowSeat;

import java.util.List;

public interface ShowSeatRepository {

    List<ShowSeat> findShowSeatIn(List<Long> showSeats);

    ShowSeat save(ShowSeat showSeat);
}
