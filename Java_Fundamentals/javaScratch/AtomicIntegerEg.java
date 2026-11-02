import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerEg {
    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(0);

        count.incrementAndGet();
        count.incrementAndGet();
        count.incrementAndGet();
        count.incrementAndGet();
        count.incrementAndGet();

        System.out.println(count.get());
    }
}