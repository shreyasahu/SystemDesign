package cache;

public class NormalCacheDriverClass {

    public static void main(String[] args) {
        EvictionPolicy<Integer> lruPolicy = new LRUEvictionPolicy<>();
        CustomCache<Integer, String> cache = new InMemoryCache<>(3, lruPolicy);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");

        System.out.println(cache.get(2));

        cache.put(4, "D");

        System.out.println(cache.get(1));
        System.out.println(cache.get(3));


    }
}
