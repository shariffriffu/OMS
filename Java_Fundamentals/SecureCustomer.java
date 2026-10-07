public class SecureCustomer {
    public static void main(String[] args) {
        Customer customer1 = new Customer();
        customer1.setName("Shariff");
        customer1.setEmail("Sharifshahid7890@gmail.com");
        System.out.println("Name = " + customer1.getName() + "Email= " + customer1.getEmail());
        System.out.println("Checking invalid email format");
        customer1.setEmail("sharif.gmail.com");
        System.out.println("Name = " + customer1.getName() + "Email= " + customer1.getEmail());

    }
}

class Customer {
    private String name;
    private String email;

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {

        if (email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Error: Invalid email format");
        }
    }

}
