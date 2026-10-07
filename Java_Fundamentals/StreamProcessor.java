
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamProcessor {

    public static void main(String[] args) {
        List<String> productList = Arrays.asList("Laptop", "Mouse", "Keyboard", "Monitor", "Desk");

        System.out.println("product List : " + productList);

        List<String> filteredProductList = productList.stream()
                .filter(product -> product.length() > 5)
                .map(product -> product.toUpperCase())
                .collect(Collectors.toList());

        System.out.println("filtered List : " + filteredProductList);
        filteredProductList.stream().forEach(System.out::println);
    }

}
