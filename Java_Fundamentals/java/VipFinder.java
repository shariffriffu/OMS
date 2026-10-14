import java.util.List;

public class VipFinder {
    public static void main(String[] args) {
        List<Customer> customers = List.of(
                new Customer("sharif", "shariff@com", 6),
                new Customer("mohammed", "mohammed@com", 2),
                new Customer("guest", "guest@com", 1));

        // stream, filter find first , map to email , fallback

        String vipEmail = customers.stream()
                .filter(c -> c.orders > 5)
                .findFirst()
                .map(c -> c.email)
                .orElse("No vip email");
        System.out.println("vipEmail = " + vipEmail);
    }
}

class Customer {
    String name;
    String email;
    int orders;

    public Customer(String name, String email, int orders) {
        this.name = name;
        this.email = email;
        this.orders = orders;

    }
}