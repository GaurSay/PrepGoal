package LowLevelDesign.ParkingLot.Services;

import LowLevelDesign.ParkingLot.Enum.BillStatus;
import LowLevelDesign.ParkingLot.Enum.ParkingSpotStatus;
import LowLevelDesign.ParkingLot.Enum.VehicleType;
import LowLevelDesign.ParkingLot.Exceptions.NoParkingSpotException;
import LowLevelDesign.ParkingLot.Models.*;
import LowLevelDesign.ParkingLot.Repositories.TicketRepository;
import LowLevelDesign.ParkingLot.Strategies.ParkingfeesStrategy;
import LowLevelDesign.ParkingLot.Strategies.SpotAssignmentStrategy;

import java.util.Date;

public class TicketService {

    private VehicleService vehicleService;
    private GateService gateService;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private TicketRepository ticketRepository;
    private ParkingfeesStrategy parkingfeesStrategy;

    public TicketService(VehicleService vehicleService, GateService gateService, SpotAssignmentStrategy spotAssignmentStrategy,
                         TicketRepository ticketRepository) {
        this.vehicleService = vehicleService;
        this.gateService = gateService;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.ticketRepository = ticketRepository;
    }


    public Ticket generateTicket(String vehicleNumber, VehicleType vehicleType, Long gateId) throws NoParkingSpotException{
        Vehicle vehicle = vehicleService.getVehicle(vehicleNumber);

        if (vehicle == null) {
            vehicle = vehicleService.registerVehicle(vehicleNumber, vehicleType);
        }

        Gate gate =  gateService.getGate(gateId);

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setGate(gate);
        ticket.setEntryTime(new Date());
        ticket.setOperator(gate.getOperator());

        //Assign parking spot to the vehicle.
        ParkingSpot spot = spotAssignmentStrategy.assignSpot(vehicleType, gate);

        if (spot == null) {
            throw new NoParkingSpotException("No Parking spot is available");
        }
        spot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);

        ticket.setParkingSpot(spot);

        Ticket savedTicket = ticketRepository.saveTicket(ticket);

        return savedTicket;


    }

    public Bill generateBill(Ticket ticket,long gateId) {
        Bill bill = new Bill();

        Gate exitgate =  gateService.getGate(gateId);

        bill.setTicket(ticket);
        bill.setGate(exitgate);
        Long exitTime = new Date().getTime();
//        double amount = parkingfeesStrategy.calculateParkingFees(ticket.getEntryTime().getTime(),exitTime);
//        bill.setAmount(amount);
        bill.setBillStatus(BillStatus.UNPAID);
        bill.setOperator(exitgate.getOperator());

        //bill repository.save(bill);
        return bill;

    }
}
