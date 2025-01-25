package threadsafebuilder.atomic;



import java.util.concurrent.atomic.AtomicReference;

public final class Product {
    private final String name;
    private final int price;
    private final String category;

    // Private constructor
    private Product(Builder builder) {
        this.name = builder.name.get();
        this.price = builder.price.get();
        this.category = builder.category.get();
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
