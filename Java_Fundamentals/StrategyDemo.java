public class StrategyDemo {
    public static void main(String[] args) {
        Order order = new Order();

        // 1. Test Standard Shipping
        order.setShippingStrategy(new StandardShipping());
        System.out.println("Standard Shipping Cost: $" + order.getShippingCost(50.0));

        // 2. Test Free Shipping (Order over $100)
        order.setShippingStrategy(new FreeShipping());
        System.out.println("Free Shipping Cost (Order $150): $" + order.getShippingCost(150.0));

        // 3. Test Free Shipping (Order under $100 - should trigger penalty)
        System.out.println("Free Shipping Cost (Order $50): $" + order.getShippingCost(50.0));
    }
}

// 1. The Strategy Interface
interface ShippingStrategy {
    double calculate(double orderTotal);
}

// 2. Concrete Strategy: Standard
class StandardShipping implements ShippingStrategy {
    public double calculate(double orderTotal) {
        return 5.0;
    }
}

// 3. Concrete Strategy: Free (with penalty if under $100)
class FreeShipping implements ShippingStrategy {
    public double calculate(double orderTotal) {
        // ??? YOUR CODE HERE ???
        // If orderTotal >= 100, return 0.0
        // Otherwise, return 10.0 (penalty)
        if (orderTotal >= 100) {
            return 0.0;
        } else {
            return 10.0;
        }
    }
}

// 4. The Context
class Order {
    private ShippingStrategy strategy;

    public void setShippingStrategy(ShippingStrategy strategy) {
        this.strategy = strategy;
    }

    public double getShippingCost(double orderTotal) {
        // ??? YOUR CODE HERE ???
        // Delegate the calculation to the current strategy
        return strategy.calculate(orderTotal);
    }
}