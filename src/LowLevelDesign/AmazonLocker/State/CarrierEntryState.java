package LowLevelDesign.AmazonLocker.State;

import LowLevelDesign.AmazonLocker.LockerMachine;
import LowLevelDesign.AmazonLocker.LockerStatus;

public class CarrierEntryState implements LockerState {

    @Override
    public void selectOption(LockerMachine machine, String option) {
        if ("DROP_PACKAGE".equals(option)) {
//            machine.setState(new AgentDeliveryState());
        }
    }

    @Override public void touch(LockerMachine m) {}
    @Override public void validateCode(LockerMachine m, String c) {}
    @Override public void closeDoor(LockerMachine m, String s) {}
    @Override public void selectCarrierEntry(LockerMachine m) {}

    @Override
    public LockerStatus getStatus() {
        return LockerStatus.BUSY;
    }
}
