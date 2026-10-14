import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentInventory {
    public static void main(String[] args) throws InterruptedException {
        // 1. Use a thread-safe map
        Map<String, Integer> inventory = new ConcurrentHashMap<>();
        inventory.put("Laptop", 1); // Only 1 laptop in stock!

        System.out.println("Initial Stock: " + inventory.get("Laptop"));

        // 2. Create two threads representing two users buying at the same time
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            inventory.computeIfPresent("Laptop", (key, stock) -> {
                System.out.println(Thread.currentThread().getName() + " checking stock...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                if (stock > 0) {
                    return stock - 1;
                } else {
                    return stock;
                }
            });
            System.out.println(Thread.currentThread().getName() + " purchased!");
        });

        executor.submit(() -> {
            inventory.computeIfPresent("laptop", (key, stock) -> {
                System.out.println(Thread.currentThread().getName() + " checking stock...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                if (stock > 0) {
                    return stock - 1;
                } else {
                    return stock;
                }
            });
        });

        executor.shutdown();
        executor.awaitTermination(1, java.util.concurrent.TimeUnit.SECONDS);
        System.out.println("Final Stock: " + inventory.get("Laptop"));
        if (inventory.get("Laptop") == 0) {
            System.out.println("✅ SUCCESS: Inventory is accurate! No race condition.");
        } else {
            System.out.println("❌ DISASTER: Race condition occurred! Stock is negative or wrong.");
        }
    }
}