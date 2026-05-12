package LowLevelDesign.AmazonLocker.Strategy;

import LowLevelDesign.AmazonLocker.Slot;

import java.util.List;

public interface SlotAssignmentStrategy {
    Slot assignSlot(List<Slot> eligibleSlots);
}
