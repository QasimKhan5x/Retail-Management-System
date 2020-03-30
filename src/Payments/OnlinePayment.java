package Payments;

public class OnlinePayment extends Payment {
	private static int ID = 0;
	private final int id;
	private static long accounts = 0;
	private long account_no;
	private String email;
	private String password;
	
	public OnlinePayment(double amount, String email, String password){
		super(amount);
		this.id = ++ID;
		this.account_no = ++accounts;
		this.email=email;
		this.password = password;
	}
	
	public OnlinePayment() {
		this(0.0, null, null);
	}

	public int getId() {
		return id;
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
		return String.format("Online Payment of Amount Rs."+getAmount()+" with ID "+getId()+" through\nthe Account Number: "+getAccountNo());
	}

	@Override
	public String toString() {
		return String.format("ID: %s\nAmount: %.2f\nAccount No: %d\nEmail: %s\nPassword: %s", getId(),getAmount(),getAccountNo(),getEmail(),getPassword());
	}
}

