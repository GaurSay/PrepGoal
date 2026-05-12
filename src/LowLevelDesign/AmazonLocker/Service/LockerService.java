package LowLevelDesign.AmazonLocker.Service;

import LowLevelDesign.AmazonLocker.Locker;
import LowLevelDesign.AmazonLocker.Package;
import LowLevelDesign.AmazonLocker.Repository.LockerRepository;
import LowLevelDesign.AmazonLocker.Slot;
import LowLevelDesign.AmazonLocker.Strategy.SlotAssignmentStrategy;

import java.util.List;
import java.util.stream.Collectors;


public class LockerService {

    private LockerRepository lockerRepository;
    private SlotAssignmentStrategy slotStrategy;

    public LockerService(LockerRepository lockerRepository,
                         SlotAssignmentStrategy slotStrategy) {
        this.lockerRepository = lockerRepository;
        this.slotStrategy = slotStrategy;
    }

    public void save(Locker locker) {
        lockerRepository.save(locker);
    }

    public Locker getByName(String name) {
        return lockerRepository.getByName(name);
    }

    // STEP 1: Find eligible lockers
    public List<Locker> getEligibleLockersByZipAndSize(String zip, Package pkg) {
        return lockerRepository.getLockersByZip(zip)
                .stream()
                .filter(locker ->
                        locker.getAllSlots()
                                .stream()
                                .anyMatch(slot ->
                                        slot.isAvailable() &&
                                                slot.getSize().canFit(pkg)
                                )
                )
                .collect(Collectors.toList());
    }

    // STEP 2: Get eligible slots
    public List<Slot> getEligibleSlotsForLocker(Locker locker, Package pkg) {
        return locker.getAllSlots()
                .stream()
                .filter(slot ->
                        slot.isAvailable() &&
                                slot.getSize().canFit(pkg)
                )
                .collect(Collectors.toList());
    }

    // STEP 3: Reserve slot
    public void reserveSlotForPackage(Locker locker, Package pkg) {
        List<Slot> eligibleSlots = getEligibleSlotsForLocker(locker, pkg);

        Slot slot = slotStrategy.assignSlot(eligibleSlots);

        if (slot == null || !slot.acquire(pkg)) {
            throw new RuntimeException("No slot available");
        }

        pkg.assignLocker(locker.getName(), slot.getSlotId());
    }



}
