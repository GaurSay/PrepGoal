package LowLevelDesign.ParkingLot.Controllers;

import LowLevelDesign.ParkingLot.Dto.GenerateTicketRequestDto;
import LowLevelDesign.ParkingLot.Dto.GenerateTicketResponseDto;
import LowLevelDesign.ParkingLot.Models.Bill;
import LowLevelDesign.ParkingLot.Models.Ticket;
import LowLevelDesign.ParkingLot.Services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto createTicket(GenerateTicketRequestDto generateTicketRequestDto){
        GenerateTicketResponseDto generateTicketResponseDto = new GenerateTicketResponseDto();
        generateTicketResponseDto.setTicket(ticketService.generateTicket(generateTicketRequestDto.getVehicleNumber(),generateTicketRequestDto.getVehicleType(),generateTicketRequestDto.getGateId()));
        return generateTicketResponseDto;

    }

    public Bill generateBill(Ticket ticket,long gateId){
        return ticketService.generateBill(ticket,gateId);
    }



}
