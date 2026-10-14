import java.util.List;

public class OmsStep1 {
    public static void main(String[] args) {
        List<Item> listOfItems = List.of(
                new Item("Laptop", 1000.0),
                new Item("Mouse", 100.0),
                new Item("Keyboard", 100.0),
                new Item("Monitor", 100.0),
                new Item("Desk", 100.0));

        for(Item item: listOfItems){
            System.out.println(item);
        }
        System.out.println("Total number of items: " + listOfItems.size());
    }

    public record Item(String name, double price) {
    }
}
