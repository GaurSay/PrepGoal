package LowLevelDesign.BMS.Models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Theatre extends BaseModel {
    private String name;
    private String address;

    private List<Audi> audi;
    private String company;
}
