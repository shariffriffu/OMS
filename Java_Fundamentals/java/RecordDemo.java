public class RecordDemo {
    public static void main(String[] args) {
        Product laptop = new Product("Macbook", 1200.0);
        Customer customer = new Customer("Shariff", "shariff@com");
        Customer newCustomer = new Customer("Riffu", "Riffu@com");

        System.out.println(laptop);
        System.out.println(customer);

        System.out.println("Customer email is :" +customer.email());

    }

    public record Customer(String name, String email) {
    }

    public record Product(String name, double price) {
    }
}
