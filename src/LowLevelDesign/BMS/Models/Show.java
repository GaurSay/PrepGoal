package LowLevelDesign.BMS.Models;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class Show extends BaseModel {

    private List<Feature> features;

//    @ManyToOne
    private Movie movie;
    private Date startTime;
    private Date endTime;

//    @ManyToOne
    private Audi audi;

//    @ElementCollection
//    @Enumerated(EnumType.ORDINAL)
    private List<Feature> showFeatures;

}
