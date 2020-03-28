package Payments;


abstract public class Payment {
    private final String id;
    private double amount;

    public Payment(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }
    
    public Payment() {
        this(null, 0);
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amout) {
        this.amount= amout;
    }

    public void addAmount(double amount) {
        this.amount += amount;
    }
    

}
