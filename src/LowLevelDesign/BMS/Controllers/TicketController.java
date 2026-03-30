package LowLevelDesign.BMS.Controllers;

import LowLevelDesign.BMS.Services.TicketService;

public class TicketController {
    private TicketService ticketService;

//    @Autowired
    TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

//    public BookTicketResponseDto bookTicket(BookTicketRequestDto requestDto) throws ShowSeatNotAvailableException {
//        Ticket ticket = ticketService.bookTicket(
//                requestDto.getShowSeatIds(),
//                requestDto.getUserId()
//        );
//
//        BookTicketResponseDto responseDto = new BookTicketResponseDto();
//        responseDto.setTicket(ticket);
//        responseDto.setResponseStatus(ResponseStatus.SUCCESS);
//
//        return responseDto;
//    }
//
//    public CancelTicketResponseDto cancelTicket(CancelTicketRequestDto requestDto) {
//        return null;
//    }
}
