package Shops;

import com.company.Item;
import java.util.HashMap;

public class Outlet extends Store {
	private String cashierName;

	public Outlet(String name, String address, double register, String cashierName) {
		super(name, address, register);
		this.cashierName = cashierName;
	}

	public Outlet(String name, String address, double register, HashMap<Item, Integer> inventory, String cashierName) {
		super(name, address, register, inventory);
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
