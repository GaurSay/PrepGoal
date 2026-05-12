package LowLevelDesign.AmazonLocker;

import lombok.Data;

import java.util.*;

@Data
public class Locker {
    private String name;
    private String zipCode;
    private Map<String, Slot> slots;

    public Locker(String name, String zipCode) {
        this.name = name;
        this.zipCode = zipCode;
        this.slots = new HashMap<>();
    }

    public void addSlot(Slot slot) {
        slots.put(slot.getSlotId(), slot);
    }

    public List<Slot> getAllSlots() {
        return new ArrayList<>(slots.values());
    }

}
