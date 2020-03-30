package Payments;


abstract public class Payment {
    private double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount= amount;
    }

    public void addAmount(double amount) {
        this.amount += amount;
    }

    public abstract String getPaymentDetails();
}
