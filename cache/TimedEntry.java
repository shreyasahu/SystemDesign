package cache;

public class TimedEntry<V> {
    private final V value;
    private final long expiryTime;

    public TimedEntry(V value, long ttlMillis) {
        this.value = value;
        this.expiryTime = System.currentTimeMillis() + ttlMillis;
    }

    public V getValue() {
        return value;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > expiryTime;
    }
}
