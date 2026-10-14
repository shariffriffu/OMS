public class ProductCatalog {
    public static void main(String[] args) {
        double[] prices = { 10.0, 25.5, 5.0, 30.0, 15.75 };
        double maxPrice = 0.0;
        for (double price : prices) {
            if (price > maxPrice) {
                maxPrice = price;
            }
        }
        System.out.println("The highest price in the catalog is : $"+ maxPrice);
    }
}