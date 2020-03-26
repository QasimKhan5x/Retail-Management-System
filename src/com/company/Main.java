package com.company;

import Payments.Payment;
import Shops.Store;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        Store nustShop = new Store("NUST Store", "C2 Back", 1000.0);

        Item pepsi = new Item("Pepsi Bottle", 50 );
        Item juice = new Item("Fresher juice", 25);
        Item chips = new Item("Lays chips", 10);
        Item chocolate = new Item("Cadbury chocolate", 30);
        Item icecream = new Item("Chocbar", 75);

        nustShop.addItem(pepsi, 10);
        nustShop.addItem(juice, 13);
        nustShop.addItem(chips, 40);
        nustShop.addItem(chocolate, 5);
        nustShop.addItem(icecream, 2);

        Customer Qasim = new Customer("Qasim Khan", "123456789", nustShop);
        Payment payment = new Payment();
        payment.addAmount(25000);
        Qasim.addPaymentMethod(payment);
        Qasim.addToCart(pepsi, 2);
        Qasim.addToCart(chips, 3);
        Qasim.addToCart(chocolate, 1);
        Qasim.addToCart(icecream, 1);
        Qasim.printBill();
    }
}
