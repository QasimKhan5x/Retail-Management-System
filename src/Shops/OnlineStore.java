package Shops;

import com.company.Item;
import java.util.HashMap;

public class OnlineStore extends Store {
	
	//web address
	 private String address;
	 
	 public OnlineStore(String name, double register, HashMap<Item, Integer> inventory,String address){
		 super(name,register,inventory);
		 this.address=address; 
	 }
	 public OnlineStore(String name, double register,String address){
		 super(name,register);
		 this.address=address; 
	 }
	 
	 public OnlineStore(){
		 this(null,0,null);
	 }
	 
	 public String getAddress() {
	        return address;
	    }
	
}
