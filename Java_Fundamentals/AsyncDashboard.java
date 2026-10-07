import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class AsyncDashboard {
    public static void main(String[] args) {
        System.out.println("[" + Thread.currentThread().getName() + "] Starting dashboard load...");

        // 1. Fetch Customer Data asynchronously
        CompletableFuture<String> customerFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("[" + Thread.currentThread().getName() + "] Fetching customer data...");
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) {}
            return "Shariff";
        });

        // 2. Fetch Order Data asynchronously
        CompletableFuture<Integer> orderFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("[" + Thread.currentThread().getName() + "] Fetching order data...");
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) {}
            return 42; 
        });

        // 3. THE FIX: Changed CompletableFuture<Void> to CompletableFuture<String>
        // because our lambda returns a String!
        CompletableFuture<String> dashboardFuture = customerFuture.thenCombine(orderFuture, (customer, order) -> {
            return "Customer: " + customer + ", Total Orders: " + order;
        });

        // 4. Print the final combined result
        dashboardFuture.thenAccept(result -> {
            System.out.println("[" + Thread.currentThread().getName() + "] ✅ Dashboard data loaded: " + result);
        });

        System.out.println("[" + Thread.currentThread().getName() + "] Main thread is NOT blocked! Doing other work...");
        
        // 5. Keep the main thread alive long enough to see the async results
        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) {}
        System.out.println("[" + Thread.currentThread().getName() + "] Dashboard loaded successfully!");
    }
}