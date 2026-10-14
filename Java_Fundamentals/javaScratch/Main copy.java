public class Main {
    public static void main(String[] args) {
        // senario 1
        Customer c = new Customer("Shariff", "shariff@com");
        System.out.println("Customer Name: " + c.getName() + ", Email: " + c.getEmail() + " is created");
        try {
            Customer c1 = new Customer("", "invalid-email");
            System.out.println("Customer Name: " + c1.getName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // senario 2
        try {
            Customer c2 = new Customer("", "shariff@com");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // senario3
        try {
            Customer c2 = new Customer(" ", "shariff@com");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        // senario 4
        try {
            Customer c2 = new Customer("Shariff", "invalid-email");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        // senario

        try {
            Customer c3 = new Customer("Riffu", "riffu@com");
            System.out.println("Customer Name: " + c3.getName() + ", Email: " + c3.getEmail() + " is created");
            c.setName(" ");
            System.out.println("Name = " + c.getName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Total number of customers: " + Customer.getCounter());

        Customer c1 = new Customer("Shariff", "shariff@com");
        Customer c2 = new BusinessCustomer(
                "Shariff", "shariff@com", "ABC Traders");

        c1.displayType(); // Regular customer
        c2.displayType(); // Business customer
    }

}

class Customer {
    private String name;
    private String email;
    private static int count = 0;

    public void displayType() {
        System.out.println("Regular customer");
    }

    public Customer(String name, String email) {
        setName(name);
        setEmail(email);
        count++;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }

    public static int getCounter() {
        return count;
    }

}

class BusinessCustomer extends Customer {
    private String companyName;

    @Override
    public void displayType() {
        System.out.println("Business customer");
    }

    public BusinessCustomer(String name, String email, String companyName) {
        super(name, email);
        if (companyName == null || companyName.isEmpty()) {
            throw new IllegalArgumentException("Company name cannot be empty");
        }
        this.companyName = companyName;

    }

}
