import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorPractice {
    public static void main(String[] args) {
        List<String> orderIds = new ArrayList<>();

        orderIds.add("ORD101");
        orderIds.add("ORD102");
        orderIds.add("ORD103");
        orderIds.add("ORD104");

        // Your task starts here
        Iterator<String> iterator = orderIds.iterator();
        while(iterator.hasNext()){
            String orderId = iterator.next();
            if(orderId.equals("ORD102")){
                iterator.remove();
            }
        }
        System.out.println("Order IDs after removing ORD102:");
        for (String orderId : orderIds) {
            System.out.println(orderId);
        }
    }
}