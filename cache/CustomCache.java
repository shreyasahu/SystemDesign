package cache;

public interface CustomCache<K,V> {
    V get(K key);

    void put(K key, V value);

    void remove(K key);

    void clear(); // clear the cache

    int size();
}
