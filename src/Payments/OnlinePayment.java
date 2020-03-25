package Payments;

import java.time.LocalDateTime;

import Payments.Payment;

// Completed by Abdul Samad
public class OnlinePayment extends Payment {
	private long account_no;
	private String email;
	private String passwd;
	
	public OnlinePayment(String id, LocalDateTime date, double amount,long account_no,String email,String passwd){
		super(id,date,amount);
		this.account_no=account_no;
		this.email=email;
		this.passwd=passwd;
	}
	
	public long getAccountNo() {
		return account_no;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return passwd;
	}
	
	@Override
	public String toString() {
		return String.format("ID: %s\nDate: %s\nAmount: %.2f\nAccount No: %d\nEmail: %s\nPassword: %s", getId(),getDate(),getAmount(),getAccountNo(),getEmail(),getPassword());
	}
}

