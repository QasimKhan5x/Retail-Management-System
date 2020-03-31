package Shops;

public class Outlet extends Store {
	private String cashierName;

	public Outlet(String address, String cashierName) {
		super(address);
		this.cashierName = cashierName;
	}

	public String getCashierName() {
		return cashierName;
	}

	public void setCashierName(String cashierName) {
		this.cashierName = cashierName;
	}

	@Override
	public String toString() {
		return super.toString() + ". Cashier Name: " + getCashierName() + ". Location: " + getAddress();
	}
}
