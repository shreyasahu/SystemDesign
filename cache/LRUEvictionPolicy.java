package cache;

import java.util.LinkedHashSet;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K> {
    public final LinkedHashSet<K> order;

    public LRUEvictionPolicy() {
        this.order = new LinkedHashSet<>();
    }


    @Override
    public K evictKey() {
        K oldKey = order.iterator().next();
        order.remove(oldKey);
        return oldKey;
    }

    @Override
    public void keyAccess(K key) {
        order.remove(key);
        order.add(key);
    }
}
