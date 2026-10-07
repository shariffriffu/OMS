import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaSorter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("shariff", "AI", "bob", "mohammed");

        Collections.sort(names, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println(names);

        names.sort((s1, s2) -> s2.compareToIgnoreCase(s1));
        System.out.println(names);
    }
}