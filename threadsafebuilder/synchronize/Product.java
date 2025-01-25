package threadsafebuilder.synchronize;

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
