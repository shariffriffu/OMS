import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAnalytics {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("Pending", 150.00),
                new Order("Shipped", 200.00),
                new Order("Delivered", 50.00),
                new Order("Pending", 300.00),
                new Order("Shipped", 100.00));
        Map<String, Long> orderCounts = orders.stream()
                .collect(Collectors.groupingBy(
                        order -> order.getStatus(),
                        Collectors.counting()));

        System.out.println("Order counts by status: " + orderCounts);

        double completedRevenue = orders.stream()
                .filter(order -> order.getStatus().equals("Delivered") || order.getStatus().equals("Shipped"))
                .mapToDouble(Order::getAmount)
                .sum();
        System.out.println("Completed revenue: $" + completedRevenue);
    }
}

class Order {
    String status;
    double amount;

    public Order(String status, double amount) {
        this.status = status;
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public double getAmount() {
        return amount;
    }

}
