package Multithreading;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    private final int capacity;
    private Map<Integer, Integer> cache;
    private LinkedList<Integer> order;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.order = new LinkedList<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        // Move key to front (most recently used)
        order.remove((Integer) key);
        order.addFirst(key);

        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            order.remove((Integer) key);
        } else if (cache.size() == capacity) {
            int leastUsed = order.removeLast();
            cache.remove(leastUsed);
        }
        cache.put(key, value);
        order.addFirst(key);
    }

    // For testing purposes
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }
}
