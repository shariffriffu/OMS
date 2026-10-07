public class OrderDiscount {
    public static void main(String[] args) {
        String customerName = "Shariff";
        boolean isPremium = true;
        double orderTotal = 200.0;
        if (isPremium) {
            double discountedTotal = orderTotal * 0.9;
            System.out.println("Hello " + customerName
                    + ", as a premium member, you get a 10% discount. Your order total is now: $" + discountedTotal);
        } else {
            System.out.println("There is no discount for non-premium members. Your order total is: $" + orderTotal);
        }
        if (customerName.equals("Shariff")) {
            System.out.println("Hello Shariff, you are a valued customer!");
        } else {
            System.out.println("Hello " + customerName + ", thank you for your order.");
        }
    }
}