package cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeBasedInMemoryCache<K, V> implements TimeBasedCache<K, V> {

    private final int capacity;
    private final Map<K, TimedEntry<V>> cache;
    private final ScheduledExecutorService cleanupScheduler;

    public TimeBasedInMemoryCache(int capacity) {
        this.capacity = capacity;
        this.cache = new ConcurrentHashMap<>();
        this.cleanupScheduler = Executors.newScheduledThreadPool(1);

        cleanupScheduler.scheduleAtFixedRate(this:: removeExpiredEntries, 1, 1, TimeUnit.SECONDS);
    }

    @Override
    public V get(K key) {
        TimedEntry<V> entry = cache.get(key);
        if (entry == null || entry.isExpired()) {
            cache.remove(key);
            return null;
        }
        return entry.getValue();
    }

    @Override
    @Deprecated
    public void put(K key, V value) {

    }

    @Override
    public void remove(K key) {
        cache.remove(key);
    }

    @Override
    public void clear() {
        cache.clear();
    }

    @Override
    public int size() {
        return cache.size();
    }

    @Override
    public void put(K key, V value, long ttlMillis) {
        if (cache.size() >= capacity) {
            K firstKey = cache.keySet().iterator().next();
            cache.remove(firstKey);
        }
        cache.put(key, new TimedEntry<>(value, ttlMillis));
    }

    public void removeExpiredEntries() {
        cache.entrySet().removeIf(entry -> entry.getValue().isExpired());
    }

    @Override
    public void shutDown() {
        cleanupScheduler.shutdown();
    }
}
