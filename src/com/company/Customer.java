package com.company;

import Orders.Order;
import Orders.OrderDetails;
import Payments.Payment;
import Shops.OnlineStore;
import Shops.Store;

import java.util.ArrayList;
import java.util.HashMap;

//buyFromStore() incomplete
public class Customer {
    private final String name;
    private String phoneNumber;
    private Store store;
    private ArrayList<Payment> paymentMethods;
    private Order order;


    public Customer(String name, String phoneNumber, Store store) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.store = store;
        this.paymentMethods = new ArrayList<>();
        this.order = new Order();
    }

    public Customer() {
        this(null, null, new Store());
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

    public ArrayList<Payment> getPaymentMethods() {
        return paymentMethods;
    }

    public void addPaymentMethod(Payment payment) {
        paymentMethods.add(payment);
    }

    public void viewProducts(Store store) {
        System.out.println(store);
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Order getOrder() {
        return order;
    }

    public void addToCart(Item item, int quantity) {
        order.addItem(item, quantity);
    }

    public void printBill() {
        System.out.printf("%-20s %-10s %-10s %-10s\n", "Items", "Quantity", "Price", "Total");
        HashMap<Item, OrderDetails> details = order.getDetails();
        int count = 0;
        for(Item item : details.keySet()) {
            System.out.printf("%-20s %-10s %-10s %-10s\n", item.getName(), details.get(item).getQuantity(),
                    item.getPrice(), details.get(item).getQuantity() * item.getPrice());
            count += details.get(item).getQuantity();
        }
        System.out.printf("%-20s %-20s\n", "Total Quantity", "Total Price");
        System.out.printf("%-20d %-20.2f", count, order.getTotalPrice());
    }

    public boolean canMakePayment(Payment payment) {
        if (!paymentMethods.contains(payment)) {
            System.out.println("You can't pay with that");
            return false;
        } else if (paymentMethods.get(paymentMethods.indexOf(payment)).getAmount() >= order.getTotalPrice()) {
            System.out.println("Insufficient balance");
            return false;
        } else {
            return true;
        }
    }


    public void makePayment(Payment payment) {
        printBill();
        store.setRegister(store.getRegister() + order.getTotalPrice());
        //Change store inventory
        HashMap<Item, OrderDetails> details = order.getDetails();
        for(Item item : details.keySet()) {
            store.changeItemQuantity(item, -details.get(item).getQuantity());
        }
    }


}
