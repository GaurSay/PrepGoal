package LowLevelDesign.BMS.Models;

import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class Ticket extends BaseModel{
    // 1 : 1
    // m  :  1
    //@ManyToOne
    private User bookedBy;

    // 1 T : 1S
    // M T    :  1S
    //@ManyToOne
    private Show show;

    // 1 : M
    // 1  : 1  // if no cancellation -> @OneToMany
//    @ManyToMany
    private List<ShowSeat> showSeats;
    private double totalAmount;

    private TicketStatus ticketStatus;

    private Date timeOfBooking;
}
