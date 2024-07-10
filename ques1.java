class TaxUtil {
    double rate = 0.15;

    public double calculateTax(double amount, double rate) {
        return amount * rate;
    }
}

public class Main {
    public static void main(String[] args) {
        double amount = 1000;
        double rate = 0.2;
        TaxUtil taxUtil = new TaxUtil();

        System.out.println("Amount: " + amount);
        System.out.println("Rate: " + rate);

        System.out.println("Tax: " + taxUtil.calculateTax(amount, rate));
    }
}