import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapInternals {
    public static void main(String[] args) {
        Map<CartItem, String> cabinet = new HashMap<>();

        // 1. Create the first object and put it in the "cabinet"
        CartItem item1 = new CartItem("Laptop", 1);
        cabinet.put(item1, "In Stock - Warehouse A");
        System.out.println("Added item1 to the map.");

        // 2. Create a SECOND object with the EXACT SAME data
        CartItem item2 = new CartItem("Laptop", 1);
        
        // 3. Try to retrieve the value using the second object
        String result = cabinet.get(item2);
        
        System.out.println("Searching for item2...");
        System.out.println("Result: " + result); 
        
        if (result == null) {
            System.out.println("❌ DISASTER: HashMap returned null! It looked in the wrong drawer.");
        } else {
            System.out.println("✅ SUCCESS: HashMap found the exact match!");
        }
    }
}

class CartItem {
    String productName;
    int quantity;

    public CartItem(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    // ==========================================
    // STEP 1: Leave these commented out and run.
    // STEP 2: Uncomment them and run again.
    // ==========================================
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return quantity == cartItem.quantity && 
               productName.equals(cartItem.productName);
    }

    @Override
    public int hashCode() {
        // This tells Java: "Calculate the drawer number based on BOTH fields"
        return Objects.hash(productName, quantity);
    }
    
}