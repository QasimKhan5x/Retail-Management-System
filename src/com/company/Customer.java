package com.company;

import Orders.Order;
import Orders.OrderDetails;
import Payments.*;
import Shops.OnlineStore;
import Shops.Outlet;
import Shops.Store;
import java.util.ArrayList;
import java.util.HashMap;


public class Customer {
	
    private final String name;
    private String phoneNumber;
    private Outlet outlet;
    private OnlineStore onlinestore;
    private ArrayList<Payment> paymentMethods;
    private Order order;


    public Customer(String name, String phoneNumber, Outlet outlet) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.outlet = outlet;
        this.paymentMethods = new ArrayList<>();
        this.order = new Order();
    }
    
    public Customer(String name, String phoneNumber, OnlineStore onlinestore) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.onlinestore = onlinestore;
        this.paymentMethods = new ArrayList<>();
        this.order = new Order();
    }

  /*  public Customer() {
        this(null, null, new Store());
    }
*/
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Payment> getPaymentMethods() {
        return paymentMethods;
    }

   //payments methods 
    public void addPaymentMethod(Card card) {
        paymentMethods.add(card);
    }
    public void addPaymentMethod(Cash cash) {
        paymentMethods.add(cash);
    }
    
    public void addPaymentMethod(OnlinePayment onlinepayment) {
        paymentMethods.add(onlinepayment);
    }
    
//changed
    public void viewProducts(Outlet outlet) {
        System.out.println(outlet);
    }
    
    public void viewProducts(OnlineStore onlinestore) {
        System.out.println(onlinestore);
    }

    public Outlet getOutlet() {
        return outlet;
    }
    
    public OnlineStore getOnlineStore() {
        return onlinestore;
    }

    public void setOutlet(Outlet outlet) {
        this.outlet = outlet;
    }

    public void setOnlineStore(OnlineStore onlinestore) {
        this.onlinestore = onlinestore;
    }
    
    
    public Order getOrder() {
        return order;
    }

    
    
    public void addToCart(Item item, int quantity) {
        order.addItem(item, quantity);
    }

    public void printBill() {
    	System.out.println("****************************************************\n");
    	
    	try {
    		System.out.printf("%25s %s\n",outlet.getName(),outlet.getAddress());
    	}
    	 catch(NullPointerException e) {
    		 System.out.printf("%25s %s\n",onlinestore.getName(),onlinestore.getAddress());
    	 }
    	System.out.println("\n****************************************************\n");
    	System.out.printf("%38s\n %40s","Cashier name: Mr.Sharjeel","Date: "+order.getReceiveDate());
    	
    	System.out.println("\n****************************************************");
        System.out.printf("%-20s %-10s %-10s %-10s\n", "Items", "Quantity", "Price", "Amount");
    	System.out.println("****************************************************");
    	
        HashMap<Item, OrderDetails> details = order.getDetails();
        int count = 0;
        for(Item item : details.keySet()) {
            System.out.printf("%-20s %-10s %-10s %-10s\n", item.getName(), details.get(item).getQuantity(),
                    item.getPrice(), details.get(item).getQuantity() * item.getPrice());
            count += details.get(item).getQuantity();
        }
    	System.out.println("\n****************************************************");
        System.out.printf("%-20s %-20s\n", "Total Quantity", "Total Price");
        System.out.printf("%-20d %-20.2f", count, order.getTotalPrice());
    	System.out.println("\n****************************************************");
    	System.out.println("****************************************************");
    	System.out.printf("%35s","Thanks for Shopping");
        
    }

    
    public boolean canMakePayment(Card card) {
        if (!paymentMethods.contains(card)) {
            System.out.println("You can't pay with that");
            return false;
        } else if (paymentMethods.get(paymentMethods.indexOf(card)).getAmount() >= order.getTotalPrice()) {
            System.out.println("Insufficient balance");
            return false;
        } else {
            return true;
        }
    }
    
    

//changes
    public void makePayment(Card card) {
        printBill();
        try {
        outlet.setRegister(outlet.getRegister() + order.getTotalPrice());
        //updating amount in cash
        double amount=(double) (card.getAmount()-order.getTotalPrice());
        card.setAmount(amount);
        
        //Change store inventory
        HashMap<Item, OrderDetails> details = order.getDetails();
        	for(Item item : details.keySet()) {
        		outlet.changeItemQuantity(item, -details.get(item).getQuantity());
        	}
        }
        catch(NullPointerException e) {
        	 onlinestore.setRegister(onlinestore.getRegister() + order.getTotalPrice());
        	 
        	 double amount=(double) (card.getAmount()-order.getTotalPrice());
             card.setAmount(amount);
             
             //Change store inventory
             HashMap<Item, OrderDetails> details = order.getDetails();
             for(Item item : details.keySet()) {
             	onlinestore.changeItemQuantity(item, -details.get(item).getQuantity());
             }
        
        }   
    }
    
    
    public void makePayment(OnlinePayment onlinepayment) {
        printBill();
        try {
        outlet.setRegister(outlet.getRegister() + order.getTotalPrice());
        //updating amount in cash
        double amount=(double) (onlinepayment.getAmount()-order.getTotalPrice());
        onlinepayment.setAmount(amount);
        
        //Change store inventory
        HashMap<Item, OrderDetails> details = order.getDetails();
        	for(Item item : details.keySet()) {
        		outlet.changeItemQuantity(item, -details.get(item).getQuantity());
        	}
        }
        catch(NullPointerException e) {
        	 onlinestore.setRegister(onlinestore.getRegister() + order.getTotalPrice());
        	 
        	 double amount=(double) (onlinepayment.getAmount()-order.getTotalPrice());
        	 onlinepayment.setAmount(amount);
             
             //Change store inventory
             HashMap<Item, OrderDetails> details = order.getDetails();
             for(Item item : details.keySet()) {
             	onlinestore.changeItemQuantity(item, -details.get(item).getQuantity());
             }
        
        }   
    }

    public void makePayment(Cash cash) {
        printBill();
        outlet.setRegister(outlet.getRegister() + order.getTotalPrice());
        //updating amount in cash
        double amount=(double) (cash.getAmount()-order.getTotalPrice());
        cash.setAmount(amount);
        
        //Change store inventory
        HashMap<Item, OrderDetails> details = order.getDetails();
        	for(Item item : details.keySet()) {
        		outlet.changeItemQuantity(item, -details.get(item).getQuantity());
        	}
    	}
}
