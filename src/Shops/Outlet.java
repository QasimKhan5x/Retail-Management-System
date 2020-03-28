package Shops;

import com.company.Item;
import java.util.HashMap;

public class Outlet extends Store {
	 private String address;
	 
	 public Outlet(String name, double register, HashMap<Item, Integer> inventory,String address){
		 super(name,register,inventory);
		 this.address=address; 
	 }
	 
	 public Outlet(String name, double register,String address){
		 super(name,register);
		 this.address=address; 
	 }
	 
	 public Outlet(){
		 this(null,0,null);
	 }
	 
	 public String getAddress() {
	        return address;
	    }
	 
	
}	
