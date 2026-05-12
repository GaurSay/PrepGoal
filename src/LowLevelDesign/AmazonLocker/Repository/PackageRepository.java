package LowLevelDesign.AmazonLocker.Repository;
import LowLevelDesign.AmazonLocker.Package;
import java.util.*;



public class PackageRepository {

    private Map<String, Package> packageById = new HashMap<>();
    private Map<String, Package> slotIdToPackage = new HashMap<>();

    public void save(Package pkg) {
        packageById.put(pkg.getPackageId(), pkg);

        if (pkg.getSlotId() != null) {
            slotIdToPackage.put(pkg.getSlotId(), pkg);
        }
    }

    public Package getById(String packageId) {
        return packageById.get(packageId);
    }

    public Package getBySlotId(String slotId) {
        return slotIdToPackage.get(slotId);
    }

    public void update(Package pkg) {
        packageById.put(pkg.getPackageId(), pkg);

        if (pkg.getSlotId() != null) {
            slotIdToPackage.put(pkg.getSlotId(), pkg);
        }
    }

    public void removeFromSlot(String slotId) {
        slotIdToPackage.remove(slotId);
    }
}
