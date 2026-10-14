import java.util.List;
import java.util.stream.Collectors;

public class LambdaPractice {
    public static void main(String[] args) {

        List<Integer> amounts = List.of(500, 1500, 500, 2500, 1500, 3000);
        amounts.stream()
                .distinct()
                .filter(amount -> amount >= 1500)
                .sorted()
                .collect(Collectors.toList())
                .forEach(amount -> System.out.println(amount));

    }
}