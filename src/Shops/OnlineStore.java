package Shops;

import com.company.Item;
import java.util.HashMap;

public class OnlineStore extends Store {

	public OnlineStore(String name, String address, double register) {
		super(name, address, register);
	}

	public OnlineStore(String name, String address, double register, HashMap<Item, Integer> inventory) {
		super(name, address, register, inventory);
	}

	@Override
	public String toString() {
		return super.toString() + ". URL: " + getAddress();
	}
}
