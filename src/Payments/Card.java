package Payments;

import com.company.Customer;

public class Card extends Payment {
	private long card_no;
	private static long cards = 0;
	private Customer owner;

	public Card(double amount, Customer owner) {
		super(amount);
		this.card_no = ++cards;
		this.owner = owner;
	}
	
    public Card() {
        this(0,null);
    }

	public long getCardNo() {
		return card_no;
	}
	
	public Customer getOwner() {
		return owner;
	}

	public String getPaymentDetails() {
		return "Card Payment of Rs."+getAmount()+" through the\n" +
				"Account Number: "+getCardNo()+"\nand the owner: "+ getOwner();
	}
	
}
