package LowLevelDesign.ParkingLot.Services;

import LowLevelDesign.ParkingLot.Models.Gate;
import LowLevelDesign.ParkingLot.Repositories.GateRepository;

public class GateService {

    GateRepository gateRepository = new GateRepository();

    public Gate getGate(Long gateId){
        return gateRepository.findById(gateId);
    }
}
