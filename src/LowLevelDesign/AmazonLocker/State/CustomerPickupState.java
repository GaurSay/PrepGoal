package LowLevelDesign.AmazonLocker.State;

import LowLevelDesign.AmazonLocker.*;
import LowLevelDesign.AmazonLocker.Package;

public class CustomerPickupState implements LockerState {

    @Override
    public void validateCode(LockerMachine machine, String code) {

        String slotId = machine.getOtpService()
                .validateAndGetSlotId(code, machine.getLocker().getName());

        System.out.println("Opening slot " + slotId);
    }

    @Override
    public void closeDoor(LockerMachine machine, String slotId) {

        Package pkg = machine.getPackageRepo().getBySlotId(slotId);
        pkg.setStatus(PackageStatus.PICKED_UP);

        // release slot
        machine.getLocker().getAllSlots()
                .stream()
                .filter(s -> s.getSlotId().equals(slotId))
                .findFirst()
                .ifPresent(Slot::release);

        machine.setState(new IdleState());
    }

    @Override public void touch(LockerMachine m) {}
    @Override public void selectCarrierEntry(LockerMachine m) {}
    @Override public void selectOption(LockerMachine m, String o) {}

    @Override
    public LockerStatus getStatus() {
        return LockerStatus.CUSTOMER_PICKUP;
    }
}
