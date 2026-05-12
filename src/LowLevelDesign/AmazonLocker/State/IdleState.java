package LowLevelDesign.AmazonLocker.State;

import LowLevelDesign.AmazonLocker.LockerMachine;
import LowLevelDesign.AmazonLocker.LockerStatus;

public class IdleState implements LockerState {

    @Override
    public void touch(LockerMachine machine) {
        System.out.println("Screen activated");
    }

    @Override
    public void selectCarrierEntry(LockerMachine machine) {
        machine.setState(new CarrierEntryState());
    }

    @Override
    public void validateCode(LockerMachine machine, String code) {
        machine.setState(new CustomerPickupState());
        machine.validateCode(code);
    }

    @Override public void closeDoor(LockerMachine m, String s) {}
    @Override public void selectOption(LockerMachine m, String o) {}

    @Override
    public LockerStatus getStatus() {
        return LockerStatus.IDLE;
    }
}
