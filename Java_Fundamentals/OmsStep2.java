
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OmsStep2 {
    public static void main(String[] args) {
        // Cart cart = new Cart.Builder()
        // .build();

        // cart.addItem(new Cart.Item("Laptop", 10000, "Shariff", LocalDate.now()));
        // cart.addItem(new Cart.Item("Mouse", 100, "riff", LocalDate.now()));
        // cart.addItem(new Cart.Item("Keyboard", 100, "seb", LocalDate.now()));

        // double grandTotal = cart.calculateTotal();
        // System.out.println("grand total :" + grandTotal);

        // Optional<Cart.Item> name = cart.findItemByName("Laptop");
        // name.ifPresentOrElse(item -> {
        // System.out.println("item found: " + item);
        // }, () -> System.out.println("item not found"));
        // cart.setDiscountStrategy(new TwentyPercentDiscount());
        // grandTotal = cart.calculateTotal();
        // System.out.println("grand total after discount :" + grandTotal);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(() -> {
            Cart cart = new Cart.Builder()
                    .setCustomerName("shariff")
                    .setOrderDate(LocalDate.now())
                    .setItemName("Laptop")
                    .setPrice(10000)
                    .setDiscountStrategy(new TwentyPercentDiscount())
                    .build();

            double grandTotal = cart.calculateTotal();
            System.out.println("grand total :" + grandTotal);
        });
        executor.submit(() -> {
            Cart cart = new Cart.Builder()
                    .setCustomerName("Riffu")
                    .setOrderDate(LocalDate.now())
                    .setItemName("mouse")
                    .setPrice(100)
                    .setDiscountStrategy(new NoDiscount())
                    .build();

            double grandTotal = cart.calculateTotal();
            System.out.println("grand total :" + grandTotal);
        });
        executor.submit(() -> {
            Cart cart = new Cart.Builder()
                    .setCustomerName("seb")
                    .setOrderDate(LocalDate.now())
                    .setItemName("keyboard")
                    .setPrice(100)
                    .setDiscountStrategy(new TwentyPercentDiscount())
                    .build();

            double grandTotal = cart.calculateTotal();
            System.out.println("grand total :" + grandTotal);
        });
        executor.shutdown();

    }
}

class Cart {
    private List<Item> items;
    private String itemName;
    private double price;
    private String customerName;
    private LocalDate orderDate;
    private DiscountStrategy discountStrategy;

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public record Item(String name, double price, String customerName, LocalDate orderDate) {
    }

    private Cart(Builder builder) {
        this.items = builder.items;
        this.itemName = builder.itemName;
        this.price = builder.price;
        this.customerName = builder.customerName;
        this.orderDate = builder.orderDate;
        this.discountStrategy = builder.discountStrategy;

    }

    public static class Builder {
        private List<Item> items = new ArrayList<>();
        private String customerName;
        private LocalDate orderDate;
        private double price;
        private String itemName;
        private DiscountStrategy discountStrategy = new NoDiscount();

        public Builder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder setOrderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder setDiscountStrategy(DiscountStrategy discountStrategy) {
            this.discountStrategy = discountStrategy;
            return this;
        }

        public Builder setItemName(String itemName) {
            this.itemName = itemName;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Cart build() {
            System.out.println("building cart" + this.price);
            Cart.Item item = new Cart.Item(this.itemName, this.price, this.customerName, this.orderDate);
            System.out.println("building cart" + item);
            this.items.add(item);
            return new Cart(this);
        }

    }

    public void addItem(Item item) {
        this.items.add(item);

    }

    public List<Item> getItems() {
        return this.items;
    }

    public double calculateTotal() {

        double total = this.items.stream()
                .mapToDouble(Item::price)
                .sum();
        return discountStrategy.applyDiscount(total);
    }

    public Optional<Item> findItemByName(String name) {
        return this.items.stream()
                .filter(item -> item.name.equals(name))
                .findFirst();
    }

}

interface DiscountStrategy {
    double applyDiscount(double total);

}

class NoDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return total;
    }
}

class TwentyPercentDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return total * 0.8;
    }
}