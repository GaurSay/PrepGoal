package LowLevelDesign.BMS.Models;

import LowLevelDesign.BookMyShow_youtube.Seat;
import LowLevelDesign.BookMyShow_youtube.Show;
import lombok.Builder;
import lombok.Data;
import java.util.List;


@Data
@Builder
public class Audi extends BaseModel {
    private String name;

    private List<Show> shows;

    private List<Feature> features;

    private List<Seat> seats;
}
