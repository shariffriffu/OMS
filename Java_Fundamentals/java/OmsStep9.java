
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class OmsStep9 {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentLinkedQueue<Cart> carts = new ConcurrentLinkedQueue<>();
        Map<String, Integer> inventry = new ConcurrentHashMap<>();
        inventry.put("laptop", 2);
        inventry.put("mouse", 5);
        inventry.put("keyboard", 5);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(() -> {
            int remainingStock = inventry.computeIfPresent("laptop", (key, stock) -> {
                if (stock > 0) {
                    System.out.println(Thread.currentThread().getName() + " purchased!");
                    return stock - 1;

                }
                System.out.println(Thread.currentThread().getName() + " out of stock!");
                return stock;
            });
            Cart cart = new Cart.Builder()
                    .setCustomerName("shariff")
                    .setOrderDate(LocalDate.now())
                    .setItemName("laptop")
                    .setPrice(10000)
                    .setDiscountStrategy(new TwentyPercentDiscount())
                    .build();
            carts.add(cart);
            double grandTotal = cart.calculateTotal();
            System.out.println("grand total :" + grandTotal);
        });

        executor.submit(() -> {
            int remainingStock = inventry.computeIfPresent("laptop", (key, stock) -> {
                if (stock > 0) {
                    System.out.println(Thread.currentThread().getName() + " purchased! " + stock);
                    return stock - 1;

                }
                System.out.println(Thread.currentThread().getName() + " out of stock!");
                return stock;
            });
            Cart cart = new Cart.Builder()
                    .setCustomerName("Riffu")
                    .setOrderDate(LocalDate.now())
                    .setItemName("laptop")
                    .setPrice(100)
                    .setDiscountStrategy(new NoDiscount())
                    .build();
            carts.add(cart);
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
            carts.add(cart);
            double grandTotal = cart.calculateTotal();
            System.out.println(Thread.currentThread().getName() + " finished! Total for " + cart.getCustomerName()
                    + " is $" + grandTotal);
        });
        executor.shutdown();
        try {
            executor.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        System.out.println("\"All carts processed successfully!\"");
        Map<String, Double> revenueReport = carts.stream()
                .collect(Collectors.groupingBy(Cart::getCustomerName, Collectors.summingDouble(Cart::calculateTotal)));

        System.out.println("Revenue Report: " + revenueReport);

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

    public String getCustomerName() {
        return this.customerName;
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