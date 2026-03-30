package LowLevelDesign.Cache;

import LowLevelDesign.Cache.policies.LRUEvictionPolicy;
import LowLevelDesign.Cache.storage.HashMapBasedStorage;

public class CacheFactory<Key, Value> {

    public Cache<Key, Value> defaultCache(final int capacity) {
        return new Cache<Key, Value>(new LRUEvictionPolicy<Key>(),
                new HashMapBasedStorage<Key, Value>(capacity));
    }
}
