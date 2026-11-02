public class DeadlockExample {
    private static final Object inventoryLock = new Object();
    private static final Object paymentLock = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            synchronized (inventoryLock) {
                System.out.println("Thread A: inventory locked");

                synchronized (paymentLock) {
                    System.out.println("Thread A: payment locked");
                }
            }
        });

        Thread threadB = new Thread(() -> {
            synchronized (paymentLock) {
                System.out.println("Thread B: payment locked");

                synchronized (inventoryLock) {
                    System.out.println("Thread B: inventory locked");
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}