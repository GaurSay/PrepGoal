package LowLevelDesign.AmazonLocker.State;

import LowLevelDesign.AmazonLocker.LockerMachine;
import LowLevelDesign.AmazonLocker.LockerStatus;

public interface LockerState {

    void touch(LockerMachine machine);

    void validateCode(LockerMachine machine, String code);

    void closeDoor(LockerMachine machine, String slotId);

    void selectCarrierEntry(LockerMachine machine);

    void selectOption(LockerMachine machine, String option);

    LockerStatus getStatus();
}
