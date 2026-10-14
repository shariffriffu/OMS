import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    public static void main(String[] args) {
        HashMap<String, Double> inventory = new HashMap<>();
        inventory.put("apple", 10.0);
        inventory.put("banana", 5.0);
        inventory.put("orange", 8.0);
        inventory.put("grape", 12.0);
        System.out.println(inventory.get("apple"));
        // for (String key : inventory.keySet()) {
        // System.out.println(key + ": " + inventory.get(key));
        // }

        for (Map.Entry<String, Double> entry : inventory.entrySet()) {
            System.out.println("Product: " + entry.getKey() + ", price: " + entry.getValue());
        }
    }
}
