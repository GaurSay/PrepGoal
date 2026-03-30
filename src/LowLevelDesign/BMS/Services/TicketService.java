package LowLevelDesign.BMS.Services;

import LowLevelDesign.BMS.Exception.SeatNotFoundException;
import LowLevelDesign.BMS.Models.*;
import LowLevelDesign.BMS.Repository.ShowRepository;
import LowLevelDesign.BMS.Repository.ShowSeatRepository;
import LowLevelDesign.BMS.Repository.TicketRepository;


import java.util.Date;
import java.util.List;

public class TicketService {

    private ShowRepository showRepository;

    private ShowSeatRepository showSeatRepository;

    private TicketPriceCalculator ticketPriceCalculator;

    private TicketRepository ticketRepository;

    public TicketService(ShowRepository showRepository,ShowSeatRepository showSeatRepository,TicketPriceCalculator ticketPriceCalculator,
        TicketRepository ticketRepository){
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.ticketPriceCalculator = ticketPriceCalculator;
        this.ticketRepository = ticketRepository;
    }


//    @Transactional(isolation = Isolation.SERIALIZABLE) // lock is already there
    public Ticket bookTicket(Long showId, List<Long> showSeatsIds) throws SeatNotFoundException {
        //1. get show with that ID
        Show show = showRepository.findShowById(showId);

        //2. get showSeat with showSeats ID's
        List<ShowSeat> showSeats = showSeatRepository.findShowSeatIn(showSeatsIds);

        //3. check if all seats are available
        for(ShowSeat showSeat : showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new SeatNotFoundException("show seat is not available for booking : " + showSeat.getId());
            }
        }

        //4. if available :
           // set seat status to locked
          for(ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatRepository.save(showSeat);
        }

//        5. create ticket
            Ticket ticket = new Ticket();
            ticket.setBookedBy(new User("shubham@gmail.com"));
            ticket.setShow(show);
            ticket.setTimeOfBooking(new Date());
            ticket.setShowSeats(showSeats);
            ticket.setTotalAmount(ticketPriceCalculator.calculateTotalPrice(showSeats));

            //6. save ticket to repository
            ticketRepository.save(ticket);


        //4.2 if any seat not available '
        //  throw exception
        return null;
    }
}
