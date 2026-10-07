public class CustomerHierarchy {
    public static void main(String[] args) {
        PremiumCustomer premiumCustomer = new PremiumCustomer();
        premiumCustomer.name = "Shariff";
        premiumCustomer.setdiscountRate(10);
        premiumCustomer.displayInfo();
        Customer customer = new PremiumCustomer();
        customer.name = "Guest";

        ((PremiumCustomer) customer).setdiscountRate(5);
        customer.displayInfo();
    }
}

class Customer {
    protected String name;

    public void displayInfo() {
        System.out.println("Regular Customer: " + name);
    }
}

class PremiumCustomer extends Customer {

    private double discountRate;

    public void setdiscountRate(double rate) {
        this.discountRate = rate;
    }

    @Override
    public void displayInfo() {
        System.out.println("Premium Customer: " + name + " | Discount: " + discountRate + "%");
    }
}