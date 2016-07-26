package July25th;
import java.util.*;
import java.util.concurrent.locks.*;

public class LRUCache {
    private int size;
    private LinkedHashMap<Integer, Integer> cache;
    private Lock lock;
    
    public LRUCache(int capacity) {
        this.size = capacity;
        lock = new ReentrantLock();
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.size;
            }
        };
    }
    
    public int get(int key) {
        try {
            lock.lock();
            if(cache.get(key) != null)
                return cache.get(key);
            return -1;
        } finally {
            lock.unlock();
        }
    }
    
    public void set(int key, int value) {
        try {
            lock.lock();
            cache.put(key, value);
        } finally {
            lock.unlock();
        }
    }
}
