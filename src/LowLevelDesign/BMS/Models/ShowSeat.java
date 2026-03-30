package LowLevelDesign.BMS.Models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Builder
public class ShowSeat extends BaseModel {

    private Show show;

    private Seat seat;

    private ShowSeatStatus showSeatStatus;
}
