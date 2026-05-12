package LowLevelDesign.AmazonLocker.Strategy;

import LowLevelDesign.AmazonLocker.Slot;

import java.util.List;

public class FirstFitSlotStrategy implements SlotAssignmentStrategy {

    @Override
    public Slot assignSlot(List<Slot> eligibleSlots) {
        for (Slot slot : eligibleSlots) {
            if (slot.isAvailable()) {
                return slot;
            }
        }
        return null;
    }
}
