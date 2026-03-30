package LowLevelDesign.BMS.Repository;

import LowLevelDesign.BMS.Models.Show;

import java.util.List;

public interface ShowRepository {
    Show findShowById(Long id);
}
