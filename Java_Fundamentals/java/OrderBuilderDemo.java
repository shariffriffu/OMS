public class OrderBuilderDemo {
    public static void main(String[] args) {
        // This is how we will use the Builder once you finish it!
        Order myOrder = new Order.Builder()
                .setOrderId("ORD-999")
                .setCustomerName("Shariff")
                .setTotalAmount(250.50)
                .setExpressShipping(true)
                .build(); // This calls your build() method

        System.out.println("Order Created: " + myOrder.getOrderId() + " for " + myOrder.getCustomerName());
        System.out.println("Express Shipping: " + myOrder.isExpressShipping());
    }
}

class Order {
    // 1. Fields are PRIVATE and FINAL (Immutable once built)
    private final String orderId;
    private final String customerName;
    private final double totalAmount;
    private final boolean isExpressShipping;

    // 2. PRIVATE Constructor (Only the Builder can call this!)
    private Order(Builder builder) {
        this.orderId = builder.orderId;
        this.customerName = builder.customerName;
        this.totalAmount = builder.totalAmount;
        this.isExpressShipping = builder.isExpressShipping;
    }

    // Getters
    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isExpressShipping() {
        return isExpressShipping;
    }

    // 3. THE BUILDER CLASS (Static nested class)
    public static class Builder {
        // Builder holds the same fields, but they are NOT final yet
        private String orderId;
        private String customerName;
        private double totalAmount;
        private boolean isExpressShipping;

        // Setter methods that return 'this' to allow chaining
        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this; // ??? WHY DO WE RETURN 'this'??? (Think about it!)
        }

        public Builder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder setExpressShipping(boolean isExpressShipping) {
            this.isExpressShipping = isExpressShipping;
            return this;
        }

        // 4. THE BUILD METHOD (Your task!)
        public Order build() {

            return new Order(this);
        }
    }
}