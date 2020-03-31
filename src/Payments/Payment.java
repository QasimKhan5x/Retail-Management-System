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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Double.compare(payment.amount, amount) == 0;
    }
}
