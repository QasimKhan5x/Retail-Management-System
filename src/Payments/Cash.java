package Payments;


public class Cash extends Payment {
	
	public Cash(String id, double amount) {
        super(id,amount);
    }
	
	public Cash(){
		this(null,0);
	}
	
	public String getPaymentDetails() {
		return String.format("The Payment of cash: "+getAmount());
		
	}
}
