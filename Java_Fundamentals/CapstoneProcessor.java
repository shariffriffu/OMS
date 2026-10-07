import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CapstoneProcessor {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("ORD-001", 150.00, new CreditCardPayment()),
                new Order("ORD-002", 600.00, new FraudCheckPayment()),
                new Order("ORD-003", 45.00, new FraudCheckPayment()));
        System.out.println(orders);

        ExecutorService executor = Executors.newFixedThreadPool(3);

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
