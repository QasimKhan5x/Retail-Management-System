package Payments;

import com.company.Customer;

public class Card extends Payment {
	private static int ID = 0;
	private final int id;
	private long card_no;
	private static long cards = 0;
	private Customer owner;

	public Card(double amount, Customer owner) {
		super(amount);
		this.id = ++ID;
		this.card_no = ++cards;
		this.owner = owner;
	}
	
    public Card() {
        this(0,null);
    }

	public int getId() {
		return id;
	}

	public long getCardNo() {
		return card_no;
	}
	
	public Customer getOwner() {
		return owner;
	}

	public String getPaymentDetails() {
		return String.format("Card Payment of Rs."+getAmount()+" with ID "+getId()+" through the\n" +
				"Account Number: "+getCardNo()+" and the owner: "+getOwner());
	}
	
}
