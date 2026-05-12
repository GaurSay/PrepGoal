package LowLevelDesign.AmazonLocker;

import lombok.Data;

import java.util.concurrent.atomic.AtomicBoolean;

@Data
public class Slot {
    private String slotId;
    private SlotSize size;
    private AtomicBoolean available;
    private Package storedPackage;

    public Slot(String slotId, SlotSize size) {
        this.slotId = slotId;
        this.size = size;
        this.available = new AtomicBoolean(true);
    }

    public boolean isAvailable() {
        return available.get();
    }

    public boolean acquire(Package pkg) {
        if (available.compareAndSet(true, false)) {
            this.storedPackage = pkg;
            return true;
        }
        return false;
    }

    public void release() {
        this.storedPackage = null;
        available.set(true);
    }
}
