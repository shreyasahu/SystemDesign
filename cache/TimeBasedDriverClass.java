package cache;

public class TimeBasedDriverClass {
    public static void main(String[] args) throws InterruptedException {
        TimeBasedCache<Integer, String> cache = new TimeBasedInMemoryCache<>(3);

        cache.put(1, "A", 2000);
        cache.put(2, "B", 1000);
        cache.put(3, "C", 3000);

        System.out.println(cache.get(1));
        Thread.sleep(1500); // Wait 1.5 seconds
        System.out.println(cache.get(2)); // Output: null (expired)
        Thread.sleep(2000);
        System.out.println(cache.get(3)); // Output: null (expired)

        cache.shutDown();
    }
}
