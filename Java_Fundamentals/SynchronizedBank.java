import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedBank {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount(100.0);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Task 1: Try to withdraw 60
        executor.submit(() -> {
            account.withdraw(60.0);
        });

        // Task 2: Try to withdraw 60
        executor.submit(() -> {
            account.withdraw(60);
        });

        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);
        
        System.out.println("Final Balance: $" + account.getBalance());
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // ??? ADD THE SYNCHRONIZED KEYWORD HERE ???
    public synchronized void withdraw(double amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw $" + amount);
        
        // Simulate slow database check
        try { Thread.sleep(200); } catch (InterruptedException e) {}

        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.println(Thread.currentThread().getName() + " SUCCESS! New balance: $" + this.balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " FAILED! Insufficient funds. Balance: $" + this.balance);
        }
    }

    public double getBalance() {
        return this.balance;
    }
}