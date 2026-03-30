package LowLevelDesign.BMS.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Movie {

    int duration;
    private String name;

//    @ManyToMany
    private List<Actor> actors;

//    @ElementCollection
//    @Enumerated(EnumType.ORDINAL)
    private List<Feature> movieFeatures;

//    @ElementCollection
//    @Enumerated(EnumType.ORDINAL)
    private List<Genre> genre;
}
