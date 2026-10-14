public class LearnInterface {
    public static void main(String[] args) {

        PaymentMethod payment = new CardPayment();
        payment.pay(100);

        payment = new CashPayment();
        payment.pay(1001);

        payment = new UPIPayment();
        payment.pay(1002);
    }

}

interface PaymentMethod {
    void pay(double amount);
}

class CardPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Card payment of $" + amount);
    }
}

class CashPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Cash payment of $" + amount);
    }
}

class UPIPayment implements PaymentMethod{
    @Override 
    public void pay(double amount){
        System.out.println("UPI payment of $" + amount);
    }
}