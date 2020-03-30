package com.company;

import Orders.Order;
import Orders.OrderDetails;
import Payments.*;
import Shops.OnlineStore;
import Shops.Outlet;
import Shops.Store;
import java.util.ArrayList;
import java.util.HashMap;


public final class Customer {
	
    private final String name;
    private String phoneNumber;
    private ArrayList<Payment> paymentMethods;
    private Order order;
    private Store storeVisited;

    public Customer(String name, String phoneNumber, Store storeVisited) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.storeVisited = storeVisited;
        this.paymentMethods = new ArrayList<>();
        this.order = new Order();
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Store getStoreVisited() {
        return storeVisited;
    }

    public void exitStore() {
        storeVisited = null;
    }

    public void visitStore(Store storeVisited) {
        if (storeVisited == this.storeVisited) System.out.println("You're already visiting this store");
        else this.storeVisited = storeVisited;
    }

    public ArrayList<Payment> getPaymentMethods() {
        return paymentMethods;
    }

    public void addPaymentMethod(Payment payment) {
        paymentMethods.add(payment);
    }

    public void viewProducts() {
        storeVisited.showInventory();
    }
    
    public Order getOrder() {
        return order;
    }
    
    public void addToCart(Item item, int quantity) {
        order.addItem(item, quantity);
    }

    public void printBill(Payment payment) {
    	System.out.println("****************************************************");
        System.out.printf("%30s\n%30s\n", storeVisited.getName(), storeVisited.getAddress());
        System.out.println("****************************************************");
        if (storeVisited instanceof Outlet) {
            Outlet outlet = (Outlet) storeVisited;
            System.out.printf("%38s\n", "Cashier Name: " + outlet.getCashierName());
        }
        System.out.printf("%30s","Date: "+order.getReceiveDate().toLocalDate());
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
        System.out.printf("%-20d %-20.2f\n", count, order.getTotalPrice());
        System.out.println(payment.getPaymentDetails());
        System.out.println("****************************************************");
        System.out.printf("%30s %s\n","Thanks for Shopping with", storeVisited.getName());
    }
    
    public boolean canMakePayment(Payment payment) {
        if (!paymentMethods.contains(payment)) {
            System.out.println("You don't have that payment method");
            return false;
        } else if (storeVisited instanceof Outlet && payment instanceof OnlinePayment) {
            System.out.println("You can't pay an outlet online");
            return false;
        } else if (storeVisited instanceof OnlineStore && payment instanceof Cash) {
            System.out.println("You can't pay an online store with cash");
            return false;
        }
        else if (payment.getAmount() <= order.getTotalPrice()) {
            System.out.println("Insufficient balance");
            return false;
        }
        return true;
    }

    public void makePayment(Payment payment) {
        if (canMakePayment(payment)) {
            printBill(payment);
            storeVisited.setRegister(storeVisited.getRegister() + order.getTotalPrice());
            payment.setAmount(payment.getAmount() - order.getTotalPrice());
            //update store inventory
            HashMap<Item, OrderDetails> details = order.getDetails();
            for (Item item : details.keySet())
                storeVisited.changeItemQuantity(item, -details.get(item).getQuantity());
        }
    }
}
