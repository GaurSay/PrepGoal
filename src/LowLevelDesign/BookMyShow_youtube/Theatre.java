package LowLevelDesign.BookMyShow_youtube;

import LowLevelDesign.BookMyShow_youtube.Enums.City;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Theatre {

    int theatreId;
    String address;
    City city;
    List<Screen> screen = new ArrayList<>();
    List<Show> shows = new ArrayList<>();

}
