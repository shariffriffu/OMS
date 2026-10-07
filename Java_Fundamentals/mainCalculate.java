public class mainCalculate {
    public static void main(String[] args) {

        String productName = "Laptop";
        int quantity = 2;
        double price = 50000.0;
        double taxRate = 18.0;

        double subtotal = price * quantity;
        double tax = subtotal * taxRate / 100;
        double total = subtotal + tax;

        System.out.println("Product  : " + productName);
        System.out.println("Quantity : " + quantity);
        System.out.println("Price    : " + price);
        System.out.println("Subtotal : " + subtotal);
        System.out.println("Tax      : " + tax);
        System.out.println("Total    : " + total);
    }
}
