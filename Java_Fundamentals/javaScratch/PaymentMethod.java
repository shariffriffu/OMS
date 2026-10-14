public class PaymentMethod {
    public static void main(String[] args) {
        PaymentMethodService service = new PaymentMethodService();

        try {
            service.pay(500);
        } catch (InvalidPaymentException e) {
            System.out.println(e.getMessage());

        }
        try {
            service.pay(-500);
        } catch (InvalidPaymentException e) {
            System.out.println(e.getMessage());

        }
        try {
            service.pay(0);
        } catch (InvalidPaymentException e) {
            System.out.println(e.getMessage());

        }
        System.out.println("Order processing completed");

    }
}

class PaymentMethodService {
    public void pay(double amount) {
        if (amount <= 0) {
            throw new InvalidPaymentException("Amount must be greater than 0");
        }
        System.out.println("Payment of $" + amount + " processed");
    }
}

class InvalidPaymentException extends RuntimeException {
    public InvalidPaymentException(String message) {
        super(message);
    }
}