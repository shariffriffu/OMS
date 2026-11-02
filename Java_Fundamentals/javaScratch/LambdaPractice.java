import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LambdaPractice {
    public static void main(String[] args) {
        List<String> statuses = List.of(
                "PENDING", "COMPLETED", "PENDING",
                "CANCELLED", "COMPLETED");
        Map<String, Long> counts = statuses.stream()
                .collect(Collectors.groupingBy(
                        status -> status,
                        Collectors.counting()));
        System.out.println(counts);
        List<String> departments = List.of(
                "IT", "HR", "IT", "FINANCE", "HR", "IT");

        Map<String, Long> departmentsCount = departments.stream()
                .collect(Collectors.groupingBy(
                        department -> department,
                        Collectors.counting()));
        System.out.println("departments count : " + departmentsCount);
    }
}