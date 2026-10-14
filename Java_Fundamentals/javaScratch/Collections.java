
public class Collections {
    public static void main(String[] args) {

        Container<String> container = new Container<>();
        container.setItem("sharif");
        OrderDetails<String, Double> order = new OrderDetails<>("ORD101", 1499.50);
        System.out.println("order details: " + order.getItemT() + " $" + order.getItemU());
        System.out.println(container.getItem());

    }

}

class Container<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

class OrderDetails<T, U> {
    private T item;
    private U item2;

    OrderDetails(T item, U item2) {
        this.item = item;
        this.item2 = item2;
    }

    public void setItemT(T item) {
        this.item = item;
    }

    public T getItemT() {
        return item;
    }

    public void setItemU(U item2) {
        this.item2 = item2;
    }

    public U getItemU() {
        return item2;
    }
}