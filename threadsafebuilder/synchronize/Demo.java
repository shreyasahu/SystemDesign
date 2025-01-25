package threadsafebuilder.synchronize;

public class Demo {
    public static void main(String[] args) {
        // Thread-safe object creation
        Product product = new Product.Builder()
                .setName("Laptop")
                .setPrice(1000)
                .setCategory("Electronics")
                .build();

        System.out.println(product);
    }
}
