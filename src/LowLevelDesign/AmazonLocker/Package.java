package LowLevelDesign.AmazonLocker;

import lombok.Data;

@Data
public class Package {
    private String packageId;
    private SlotSize size;
    private PackageStatus status;
    private String lockerName;
    private String slotId;
    private String agentId;

    public Package(String packageId, SlotSize size) {
        this.packageId = packageId;
        this.size = size;
        this.status = PackageStatus.CREATED;
    }

    public void assignLocker(String lockerName, String slotId) {
        this.lockerName = lockerName;
        this.slotId = slotId;
        this.status = PackageStatus.STORED_IN_LOCKER;
    }
}
