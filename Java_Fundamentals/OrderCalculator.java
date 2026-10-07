public class OrderCalculator {
    public static void main(String[] args) {
        double itemPrice = 100.0;
        double tax = 0.08;
        double finalPrice = calculateTax(itemPrice, tax);
        System.out.println("The final price after tax is: $" + finalPrice);
    }

    public static double calculateTax(double originalPrice, double taxRate) {
        double totalPrice = originalPrice + (originalPrice * taxRate);
        return totalPrice;
    }
}
