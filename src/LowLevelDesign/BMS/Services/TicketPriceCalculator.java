package LowLevelDesign.BMS.Services;

import LowLevelDesign.BMS.Models.Show;
import LowLevelDesign.BMS.Models.ShowSeat;
import LowLevelDesign.BMS.Models.ShowSeatType;
import LowLevelDesign.BMS.Repository.ShowSeatTypeRepository;

import java.util.List;

public class TicketPriceCalculator {

    private ShowSeatTypeRepository showSeatTypeRepository;

    public TicketPriceCalculator(ShowSeatTypeRepository showSeatTypeRepository){
    this.showSeatTypeRepository = showSeatTypeRepository;
    }



    public double calculateTotalPrice(List<ShowSeat> showSeats){

        Show show = showSeats.get(0).getShow();

        //1. get ShowSeatType object for this show
        List<ShowSeatType> showSeatTypes =  showSeatTypeRepository.findAllShowSeatTypeByShow(show);

        double totalAmount = 0;

        for(ShowSeat showSeat : showSeats) {
            for (ShowSeatType showSeatType : showSeatTypes) {
                if (showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                    totalAmount += showSeatType.getPrice();
                }
            }
        }

        return totalAmount;
    }

}
