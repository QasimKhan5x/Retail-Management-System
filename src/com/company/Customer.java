package com.company;

import Orders.Order;
import Orders.OrderDetails;
import Payments.*;
import Shops.OnlineStore;
import Shops.Outlet;
import Shops.Store;

import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

import MainGui.GuiClass;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import Shops.OnlineStore;
import Shops.Outlet;
import Shops.Store;
import Payments.Card;
import Payments.Cash;
import Payments.OnlinePayment;
import Payments.Payment;
import com.company.*;



public final class Customer {
	
    private final String name;
    private String phoneNumber;
    private ArrayList<Payment> paymentMethods;
    private Order order;
    public Store storeVisited;

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
        Store.changeItemQuantity(item, -quantity);
    }

    public void removeFromCart(Item item) {
        if (Store.getInventory().containsKey(item)) {
            Store.changeItemQuantity(item, order.getDetails().get(item).getQuantity());
        } else
            Store.addItem(item, order.getDetails().get(item).getQuantity());
        order.getDetails().remove(item);
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
        	Store.setRegister(Store.getRegister() + order.getTotalPrice());
            payment.setAmount(payment.getAmount() - order.getTotalPrice());
            //update store inventory
            HashMap<Item, OrderDetails> details = order.getDetails();
            for (Item item : details.keySet())
               Store.changeItemQuantity(item, -details.get(item).getQuantity());
        }
    }
    
    
    
    

    
    public void guiBill(Payment payment) {
    	JFrame frame = new JFrame();
		frame.setBounds(30, 30, 500, 700);
		JLabel l1 = new JLabel("************************************************************************************************");
		JLabel l2 = new JLabel(Store.getName());
		l2.setFont(new Font(storeVisited.getName(), Font.BOLD,30));
		JLabel l3 = new JLabel(storeVisited.getAddress());
		JLabel l4 = new JLabel("");
		JLabel l5 = new JLabel("");
		JLabel l6 = new JLabel("Retail Bill");
		JLabel l7 = new JLabel("************************************************************************************************");
		JLabel l8 = new JLabel("Cashier name: "+GuiClass.outlet.getCashierName());
		JLabel l9 = new JLabel("Order Date: "+order.getReceiveDate().toLocalDate());
		JLabel l10 = new JLabel("------------------------------------------------------------------------------------------------------------------------");
		JLabel l11 = new JLabel("S.No");
		JLabel l12 = new JLabel("Product");
		JLabel l13 = new JLabel("Qty");
		JLabel l14 = new JLabel("Rate");
		JLabel l15 = new JLabel("Amount");
		JLabel l21 = new JLabel("------------------------------------------------------------------------------------------------------------------------");
		JLabel l22 = new JLabel("Total:");
		JLabel l223 = new JLabel("Rs. "+order.getTotalPrice());
		JLabel l23 = new JLabel(payment.getPaymentDetails());
		JLabel l24 = new JLabel("------------------------------------------------------------------------------------------------------------------------");
		JLabel l25 = new JLabel("Thanks for shopping");
		
		l1.setBounds(0, 10, 500, 10);
		l2.setBounds(120, 20, 300, 40);
		l3.setBounds(185, 75, 120, 20);
		l4.setBounds(190, 85, 120, 20);
		l5.setBounds(160, 110, 150, 20);
		l6.setBounds(185, 135, 80, 20);
		l7.setBounds(0, 160, 500, 10);
		l8.setBounds(5, 170, 160, 20);
		l9.setBounds(270, 170, 200, 20);
		l10.setBounds(0, 220, 500, 10);
		l11.setBounds(5, 230, 40, 20);
		l12.setBounds(90, 230, 80, 20);
		l13.setBounds(210, 230, 40, 20);
		l14.setBounds(290, 230, 50, 20);
		l15.setBounds(380, 230, 50, 20);
		l21.setBounds(0, Store.inventory.size()*20 +263, 500, 10);
		l22.setBounds(5, Store.inventory.size()*20 +275, 110, 20);
		l223.setBounds(365, Store.inventory.size()*20 +275, 110, 20);
		l23.setBounds(5, Store.inventory.size()*20 +300, 3000, 20);
		l24.setBounds(0, Store.inventory.size()*20 +325, 500, 10);
		l25.setBounds(170, Store.inventory.size()*20 +340, 130, 20);
		
		
		int i=1;
		HashMap<Item, OrderDetails> details = order.getDetails();
        int count = 0;
		for(Item item : details.keySet()) {
			
			JLabel l16 = new JLabel(Integer.toString(i));
			JLabel l17 = new JLabel(item.getName()/*sCart.cart.get(i-1)*/);
			JLabel l18 = new JLabel(Integer.toString(details.get(item).getQuantity()));
			JLabel l19 = new JLabel(Double.toString(item.getPrice()));
			JLabel l20 = new JLabel(Double.toString(details.get(item).getQuantity() * item.getPrice()));
			
			l16.setBounds(5, 250 + (i*20), 40, 20);
			l17.setBounds(90, 250 + (i*20), 80, 20);
			l18.setBounds(210, 250 + (i*20), 40, 20);
			l19.setBounds(290, 250 + (i*20), 40, 20);
			l20.setBounds(380, 250 + (i*20), 40, 20);
			
			 frame.add(l16);
			 frame.add(l17);
			 frame.add(l18);
			 frame.add(l19);
			 frame.add(l20);
			 i++;
		}
		
		 frame.setLayout(null);
		 frame.setVisible(true);
		 frame.add(l1);
		 frame.add(l2);
		 frame.add(l3);
		 frame.add(l4);
		 frame.add(l5);
		 frame.add(l6);
		 frame.add(l7);
		 frame.add(l8);
		 frame.add(l9);
		 frame.add(l10);
		 frame.add(l11);
		 frame.add(l12);
		 frame.add(l13);
		 frame.add(l14);
		 frame.add(l15);
		 frame.add(l21);
		 frame.add(l22);
		 frame.add(l23);
		 frame.add(l24);
		 frame.add(l25);
		 frame.add(l223);
		 
	   	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   	 frame.setDefaultLookAndFeelDecorated(true);
    	
    }

    
    public void makePaymentGui(Payment payment) {
        if (canMakePayment(payment)) {
            guiBill(payment);
            Store.setRegister(Store.getRegister() + order.getTotalPrice());
            payment.setAmount(payment.getAmount() - order.getTotalPrice());
            //update store inventory
            HashMap<Item, OrderDetails> details = order.getDetails();
            for (Item item : details.keySet())
               Store.changeItemQuantity(item, -details.get(item).getQuantity());
        }
    }

    @Override
    public String toString() {
        return name + ". Ph: " + phoneNumber;
    }
}
