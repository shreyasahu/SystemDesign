package cache;

public interface TimeBasedCache<K, V> extends CustomCache<K, V> {

    void put(K key, V value, long ttlMillis); // Add with time to live

    void shutDown();
}
