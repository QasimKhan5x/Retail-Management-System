package Payments;


public class Cash extends Payment {
	
	public Cash(double amount) {
        super(amount);
    }
	
	public Cash(){
		this(0);
	}
	
	public String getPaymentDetails() {
		return String.format("Cash payment: "+ getAmount());
	}
}
