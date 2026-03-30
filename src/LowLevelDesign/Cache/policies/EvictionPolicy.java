package LowLevelDesign.Cache.policies;

import LowLevelDesign.Cache.Exceptions.NoSuchElementException;

public interface EvictionPolicy<Key> {

    void keyAccessed(Key key);

    /**
     * Evict key from eviction policy and return it.
     */
    Key evictKey() throws NoSuchElementException;
}