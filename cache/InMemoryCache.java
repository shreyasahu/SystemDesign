package cache;

import java.util.Map;

public class InMemoryCache<K, V> implements CustomCache<K, V> {
    private final int capacity;
    private final Map<K, V> storage;
    private EvictionPolicy<K> evictionPolicy;


    public InMemoryCache(int capacity, Map<K, V> storage, EvictionPolicy<K> evictionPolicy) {
        this.capacity = capacity;
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }


    @Override
    public V get(K key) {
        if (storage.containsKey(key)) {
            evictionPolicy.keyAccess(key);
            return storage.get(key);
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        // check if storage is full
        if (storage.size() >= capacity) {
            K evictedKey = evictionPolicy.evictKey();
            storage.remove(evictedKey);
        }
        storage.put(key, value);
        evictionPolicy.keyAccess(key);
    }

    @Override
    public void remove(K key) {
        storage.remove(key);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }
}
