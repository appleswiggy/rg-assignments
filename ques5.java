public class PayPalTransaction {
    // Private variables to store transaction details
    private String transactionId;
    private double amount;
    private String senderEmail;
    private String receiverEmail;

    // Constructor to initialize transaction details
    public PayPalTransaction(String transactionId, double amount, String senderEmail, String receiverEmail) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.senderEmail = senderEmail;
        this.receiverEmail = receiverEmail;
    }

    // Public getter and setter methods for accessing private variables

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount > 0) {
            this.amount = amount;
        } else {
            System.out.println("Amount must be positive.");
        }
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        if (isValidEmail(senderEmail)) {
            this.senderEmail = senderEmail;
        } else {
            System.out.println("Invalid sender email.");
        }
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        if (isValidEmail(receiverEmail)) {
            this.receiverEmail = receiverEmail;
        } else {
            System.out.println("Invalid receiver email.");
        }
    }

    // Private method to validate email format
    private boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    // Method to display transaction details
    public void displayTransactionDetails() {
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Amount: $" + amount);
        System.out.println("Sender Email: " + senderEmail);
        System.out.println("Receiver Email: " + receiverEmail);
    }

    public static void main(String[] args) {
        // Creating a PayPal transaction object
        PayPalTransaction transaction = new PayPalTransaction("TX12345", 100.50, "sender@example.com", "receiver@example.com");
        
        // Displaying transaction details
        transaction.displayTransactionDetails();

        // Attempting to set invalid email
        transaction.setSenderEmail("invalid-email");
        
        // Updating amount
        transaction.setAmount(150.75);
        
        // Displaying updated transaction details
        transaction.displayTransactionDetails();
    }
}