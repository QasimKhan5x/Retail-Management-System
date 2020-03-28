package Payments;

public class OnlinePayment extends Payment {
	private long account_no;
	private String email;
	private String password;
	
	public OnlinePayment(String id, double amount, long account_no, String email, String password){
		super(id,amount);
		this.account_no=account_no;
		this.email=email;
		this.password = password;
	}
	
	public OnlinePayment() {
		this(null,0,0L,null,null);
	}
	
	public long getAccountNo() {
		return account_no;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getPaymentDetails() {
		return String.format("Online Payment of Amount of Rs."+getAmount()+" with ID"+getId()+" through the Account Number: "+getAccountNo());
	}
	
	
	@Override
	public String toString() {
		return String.format("ID: %s\nAmount: %.2f\nAccount No: %d\nEmail: %s\nPassword: %s", getId(),getAmount(),getAccountNo(),getEmail(),getPassword());
	}
}

