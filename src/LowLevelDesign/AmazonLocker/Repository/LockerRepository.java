package LowLevelDesign.AmazonLocker.Repository;

import LowLevelDesign.AmazonLocker.Locker;

import java.util.*;

public class LockerRepository {

    private Map<String, Locker> lockers = new HashMap<>();
    private Map<String, List<Locker>> zipToLockersMap = new HashMap<>();

    public void save(Locker locker) {
        lockers.put(locker.getName(), locker);

        zipToLockersMap
                .computeIfAbsent(locker.getZipCode(), z -> new ArrayList<>())
                .add(locker);
    }

    public Locker getByName(String name) {
        return lockers.get(name);
    }

    public List<Locker> getLockersByZip(String zip) {
        return zipToLockersMap.getOrDefault(zip, Collections.emptyList());
    }
}
