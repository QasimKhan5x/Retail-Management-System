package Shops;

public class OnlineStore extends Store {

	public OnlineStore(String address) {
		super(address);
	}

	@Override
	public String toString() {
		return super.toString() + ". URL: " + getAddress();
	}
}
