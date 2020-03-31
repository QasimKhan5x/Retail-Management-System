package Payments;

public class OnlinePayment extends Payment {
	private static long accounts = 0;
	private long account_no;
	private String email;
	private String password;
	
	public OnlinePayment(double amount, String email, String password){
		super(amount);
		this.account_no = ++accounts;
		this.email=email;
		this.password = password;
	}
	
	public OnlinePayment() {
		this(0.0, null, null);
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		OnlinePayment that = (OnlinePayment) o;
		return account_no == that.account_no &&
				email.equals(that.email) &&
				password.equals(that.password);
	}

	public String getPaymentDetails() {
		return "Online Payment of Amount Rs."+getAmount()+" through\nthe Account Number: "+getAccountNo();
	}

	@Override
	public String toString() {
		return String.format("Amount: %.2f\nAccount No: %d\nEmail: %s\nPassword: %s", getAmount(),getAccountNo(),getEmail(),getPassword());
	}
}

