package LowLevelDesign.BMS.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class City extends BaseModel{
    private String name;

//    @OneToMany
    private List<Theatre> theatres;
}
