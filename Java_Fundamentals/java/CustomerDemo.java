
public class CustomerDemo {

    public static void main(String[] args) {
        Customer customer1 = new Customer();
        customer1.name = "Shariff";
        customer1.email = "shariff@com";
        System.out.println("Customer Name: " + customer1.name + ", Email: " + customer1.email);
        
    }
}
class Customer {
    String name;
    String email;
}
