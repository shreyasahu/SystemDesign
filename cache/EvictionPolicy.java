package cache;

public interface EvictionPolicy<K> {
    K evictKey(); // key to evict
    void keyAccess(K key); // whether key is accessed
}
