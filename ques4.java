// Create the Singleton class
class PayPalProcessor {

    // Create a private static variable to hold the single instance of the class
    private static PayPalProcessor instance;

    // Make the constructor private so that this class cannot be instantiated from outside
    private PayPalProcessor() {
        // Initialize the PayPal connection or API setup here
    }

    // Provide a public static method that returns the instance of the class
    public static PayPalProcessor getInstance() {
        if (instance == null) {
            // Lazily initialize the instance if it doesn't exist
            instance = new PayPalProcessor();
        }
        return instance;
    }

    // Add methods to process payments
    public void processPayment(double amount) {
        // Simulate payment processing logic here
        System.out.println("Processing payment of $" + amount + " through PayPal.");
    }
}

public class PaymentService {

    public static void main(String[] args) {
        // Get the single instance of PayPalProcessor
        PayPalProcessor paypal = PayPalProcessor.getInstance();

        // Process a payment
        paypal.processPayment(150.00);
        
        // Get the same instance again
        PayPalProcessor samePaypal = PayPalProcessor.getInstance();
        
        // Process another payment
        samePaypal.processPayment(75.00);
        
        // Check if both instances are the same
        if (paypal == samePaypal) {
            System.out.println("Both instances are the same.");
        } else {
            System.out.println("Instances are different.");
        }
    }
}
