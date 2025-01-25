/*
* Implement builder pattern in a thread safe way (LLD)
* First by synchronized and atomic reference
*/

| Feature             | AtomicReference                                  | synchronized                                   |
|---------------------|--------------------------------------------------|-----------------------------------------------|
| **How it works**    | Non-blocking, lock-free (uses CAS).              | Blocking, locks the resource for one thread.  |
| **Example Use**     | Single-variable updates (e.g., counters).        | Complex logic with multiple variables (e.g., bank accounts). |
| **Performance**     | Faster, no waiting unless retries are needed.    | Slower due to thread blocking.                |
| **Complexity**      | Easy for simple operations, harder for compound. | Simpler for complex operations with multiple steps. |
| **Risk of Deadlock**| No deadlocks (lock-free).                        | Deadlocks possible if locking is misused.     |



  | Scenario                              | Use AtomicReference                | Use synchronized                     |
|---------------------------------------|------------------------------------|--------------------------------------|
| **Single Variable Updates**           | ✅                                  | ❌                                   |
| **High-Concurrency (Many Threads)**   | ✅ (Efficient, non-blocking)        | ❌ (Locks may slow things down)      |
| **Multiple Variable/Step Updates**    | ❌                                  | ✅                                   |
| **Avoiding Deadlocks**                | ✅ (No locks involved)              | ❌ (Locks can lead to deadlocks)     |
| **Complex Multi-Step Logic**          | ❌                                  | ✅                                   |
| **Performance Under Low Contention**  | ✅                                  | ✅                                   |
| **Legacy Code or Broad Synchronization** | ❌                               | ✅                                   |


// Immutable Product Class
public final class Product {
    private final String name;
    private final int price;
    private final String category;

    // Private constructor to enforce usage of the Builder
    private Product(Builder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.category = builder.category;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    // Thread-safe Builder Class
    public static class Builder {
        private String name;
        private int price;
        private String category;

        // Synchronized methods for thread safety
        public synchronized Builder setName(String name) {
            this.name = name;
            return this;
        }

        public synchronized Builder setPrice(int price) {
            this.price = price;
            return this;
        }

        public synchronized Builder setCategory(String category) {
            this.category = category;
            return this;
        }

        // Synchronized build method
        public synchronized Product build() {
            return new Product(this);
        }
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + ", category='" + category + "'}";
    }
}

// Example Usage
public class Main {
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

================================================================================================================================================================


  import java.util.concurrent.atomic.AtomicReference;

public final class Product {
    private final String name;
    private final int price;
    private final String category;

    // Private constructor
    private Product(Builder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.category = builder.category;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    // Thread-safe Builder using AtomicReference
    public static class Builder {
        private final AtomicReference<String> name = new AtomicReference<>();
        private final AtomicReference<Integer> price = new AtomicReference<>(0);
        private final AtomicReference<String> category = new AtomicReference<>();

        public Builder setName(String name) {
            this.name.set(name);
            return this;
        }

        public Builder setPrice(int price) {
            this.price.set(price);
            return this;
        }

        public Builder setCategory(String category) {
            this.category.set(category);
            return this;
        }

        // Build method to create the Product
        public Product build() {
            // Read atomic values for thread-safe construction
            return new Product(this);
        }

        private String getName() {
            return name.get();
        }

        private int getPrice() {
            return price.get();
        }

        private String getCategory() {
            return category.get();
        }
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + ", category='" + category + "'}";
    }
}

// Example Usage
public class Main {
    public static void main(String[] args) {
        // Thread-safe object creation
        Product product = new Product.Builder()
            .setName("Phone")
            .setPrice(800)
            .setCategory("Electronics")
            .build();

        System.out.println(product);
    }
}

