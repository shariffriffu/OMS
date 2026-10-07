public class OrderProcessor {
    public static void main(String[] args) {
        int totalItems = 10;
        int numberOfCustomers = 0;

        try {
            int itemPerCustomer = totalItems / numberOfCustomers;
            System.out.println("Each customer will receive " + itemPerCustomer + " items.");
        } catch (Exception e) {
            System.out.println("Business Error: Cannot distribute items to zero customers!");
        } finally {
            System.out.println("Order processing attempt finished.");
        }

        int orderQuantity = -5;
        if(orderQuantity < 0) {
            throw new IllegalArgumentException("Order quantity cannot be negative.");
        } else {
            System.out.println("No items to process.");
        }
    }
}