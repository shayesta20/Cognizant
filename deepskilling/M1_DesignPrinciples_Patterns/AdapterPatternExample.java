interface PaymentProcessor {
    void processPayment(double amount);
}

class StripeGateway {
    public void makePayment(double amount) {
        System.out.println("Stripe payment processed: $" + amount);
    }
}

class PayPalGateway {
    public void sendPayment(double amount) {
        System.out.println("PayPal payment processed: $" + amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private final StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amount) {
        stripeGateway.makePayment(amount);
    }
}

class PayPalAdapter implements PaymentProcessor {
    private final PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public void processPayment(double amount) {
        payPalGateway.sendPayment(amount);
    }
}

public class AdapterTest {
    public static void main(String[] args) {
        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());
        PaymentProcessor paypal = new PayPalAdapter(new PayPalGateway());

        stripe.processPayment(150.0);
        paypal.processPayment(200.0);
    }
}
