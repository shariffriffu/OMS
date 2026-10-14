import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class CapstoneProcessor {
    public static void main(String[] args) throws InterruptedException {
        List<Order> orders = List.of(
                new Order("ORD-001", 150.00, new CreditCardPayment()),
                new Order("ORD-002", 600.00, new FraudCheckPayment()),
                new Order("ORD-003", 45.00, new FraudCheckPayment()));
        System.out.println(orders);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<ProcessingResult>> futures = new ArrayList<>();

        for (Order o : orders) {
            futures.add(executor.submit(() -> processOrder(o)));
        }
        executor.shutdown();
        executor.awaitTermination(3, TimeUnit.SECONDS);
        List<String> successfulOrderIds = futures.stream()
                // 1. Unwrap the Future to get the ProcessingResult
                .map(f -> {
                    try {
                        return f.get();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                // 2. Filter ONLY the successful ones
                // (Hint: your record field is named 'success', so the accessor is
                // result.success())
                .filter(result -> result.success())
                // 3. Extract just the Order ID string
                .map(result -> result.orderId())
                // 4. Collect into a List
                .collect(Collectors.toList());

        System.out.println("\n📊 FINAL REPORT:");
        System.out.println("Successfully Processed Orders: " + successfulOrderIds);

    }

    public record Order(String orderId, double amount, PaymentStrategy paymentStrategy) {
    }

    public record ProcessingResult(String orderId, boolean success, String message) {
    }

    static ProcessingResult processOrder(Order order) {
        System.out.println(Thread.currentThread().getName() + " processing " + order.orderId());
        boolean success = order.paymentStrategy().process(order.amount());
        String message = success ? "Approved" : "Declined";
        return new ProcessingResult(order.orderId(), success, message);
    }
}

interface PaymentStrategy {
    boolean process(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    @Override
    public boolean process(double amount) {
        return true;
    }
}

class FraudCheckPayment implements PaymentStrategy {
    @Override
    public boolean process(double amount) {
        if (amount <= 500) {
            return true;
        } else {
            return false;
        }

    }
}
