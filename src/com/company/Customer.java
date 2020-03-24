package com.company;

import Orders.Order;
import Payments.Payment;
import Shops.Store;

import java.util.ArrayList;

//buyFromStore() incomplete
public class Customer {
    private final String name;
    private String phoneNumber;
    private ArrayList<Payment> paymentMethods;
    private ArrayList<Order> ordersMade;


    public Customer(String name, String phoneNumber, ArrayList<Payment> paymentMethods,
                    ArrayList<Order> ordersMade) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.paymentMethods = paymentMethods;
        this.ordersMade = ordersMade;
    }

    public Customer() {
        this(null, null, new ArrayList<>(), new ArrayList<>());
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

    public void setPaymentMethods(ArrayList<Payment> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public void makeOrder(Order order) {
        ordersMade.add(order);
    }

    public void buyFromStore(Store store) {
        //Give order to store
        //Make Payment
        //Buy Item
    }
}
