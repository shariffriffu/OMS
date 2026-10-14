import java.util.ArrayList;

public class OrderManager {
    public static void main(String[] args) {
        ArrayList<String> orders = new ArrayList<>();

        orders.add("ORD101");
        orders.add("ORD102");
        orders.add("ORD103");

        System.out.println(orders.get(1));
        orders.remove(0);
        System.out.println(orders);

        for(String order : orders) {
            System.out.println(order);
        }
    }
}