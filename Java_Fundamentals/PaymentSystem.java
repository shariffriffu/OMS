public class PaymentSystem {
    public static void main(String[] args) {
        NotificationService notifier = new EmailNotification();
        notifier.sendNotification("Your order is shipped");

        notifier = new SmsNotification();
        notifier.sendNotification("Your order is shipped");

    }
}

interface NotificationService {
    void sendNotification(String message);
}

class EmailNotification implements NotificationService {

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending Email: " + message);
    }
}

class SmsNotification implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS: " + message);
    }

}