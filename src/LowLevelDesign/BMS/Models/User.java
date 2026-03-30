package LowLevelDesign.BMS.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User extends BaseModel{
    private String email;
}
