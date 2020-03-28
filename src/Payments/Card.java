package Payments;

//need to pull on github
public class Card extends Payment {
	private long card_no;
	private String card_owner;

	public Card(String id, double amount,long card_no,String owner) {
		super(id,amount);
		this.card_no=card_no;
		this.card_owner=card_owner;
	}
	
    public Card() {
        this(null,0,0L,null);
    }
	
	public long getCardNo() {
		return card_no;
	}
	
	public String getOwner() {
		return card_owner;
	}
	
	
	//@Override
	public String getPaymentDetails() {
		return String.format("Payment through card of Amount Rs."+getAmount()+" with ID"+getId()+" through the Account Number: "+getCardNo()+" and the owner: "+getOwner());
	}
	
}
