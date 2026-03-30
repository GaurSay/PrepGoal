package LowLevelDesign.BMS.Repository;

import LowLevelDesign.BMS.Models.Show;
import LowLevelDesign.BMS.Models.ShowSeatStatus;
import LowLevelDesign.BMS.Models.ShowSeatType;

import java.util.List;

public interface ShowSeatTypeRepository {

    public List<ShowSeatType> findAllShowSeatTypeByShow(Show show);

}
