package com.company;

import Payments.*;
import Shops.*;
import com.company.*;

//changes nee to pull on github
import java.util.ArrayList;

public class Main {
	
    public static void main(String[] args) {
 
    	//Outlet demo
    	/*Outlet nustbakers = new Outlet("NUST Bakers", "Concordia 2, SEECS",
				10000, "Mr. Sharjeel");
    	
    	Item chocolate=new Item("Kitkat",100);
    	Item milk=new Item("Prema Milk",150);
    	Item sweets = new Item("Cake",500);
    	Item chips= new Item("Lays",50);
    	Item biscuit= new Item("Cocomo",10);
    	
    	
    	nustbakers.addItem(milk,15);
    	nustbakers.addItem(chips,20);
    	nustbakers.addItem(biscuit,10);
       	nustbakers.addItem(chocolate,25);
    	nustbakers.addItem(sweets,5);
    	nustbakers.addItem(milk,10);

    	Customer Samad = new Customer("Abdul Samad", "03003420840", nustbakers);
    	Samad.addToCart(milk, 2);
    	Samad.addToCart(chips, 4);
    	Samad.addToCart(sweets, 1);
    	Samad.addToCart(chocolate, 5);
    	//Samad.printBill();
    	
    	System.out.println("Inventory before payment");
		nustbakers.showInventory();
    	
 
    	
    	Card card = new Card();
    	Cash cash = new Cash();
    	
        card.addAmount(25000);
        cash.addAmount(200);

       	System.out.println("Amount before payment: "+cash.getAmount());
       	
        Samad.addPaymentMethod(cash);
        Samad.addPaymentMethod(card);
        Samad.makePayment(card);

        System.out.println("\nAmount After payment: "+cash.getAmount());
        System.out.println();
        System.out.println("Inventory After payment");
    	nustbakers.showInventory(); */


    	//online store demo
    	OnlineStore daraz = new OnlineStore("Daraz", "https://www.daraz.pk/", 100000);
    	
    	Item chair=new Item("Chair",1000);
    	Item jacket=new Item("Jacket",1500);
    	Item table = new Item("Table",2500);
    	Item book= new Item("Book",100);
    	Item glasses= new Item("Glasses",1000);
    	
    	
    	daraz.addItem(chair,30);
    	daraz.addItem(jacket,15);
    	daraz.addItem(table,20);
    	daraz.addItem(book,5);
    	daraz.addItem(glasses,50);
    	
    	Customer Qasim = new Customer("Qasim Khan", "123456789", daraz);
    	
    	Qasim.addToCart(chair, 2);
        Qasim.addToCart(jacket, 3);
        Qasim.addToCart(table, 1);
        Qasim.addToCart(book, 1);
        
        daraz.showInventory();
       
    	Card card2 = new Card();
    	Cash cash2 = new Cash();
    	OnlinePayment op= new OnlinePayment();
    	
        card2.addAmount(50000);
        cash2.addAmount(40000);
        op.addAmount(30000);
        System.out.println("Amount Before payment: "+card2.getAmount());
        System.out.println("Amount Before payment: "+cash2.getAmount());
        System.out.println("Amount Before payment: "+op.getAmount());

   //     payments methods demo
        Qasim.addPaymentMethod(card2);
        Qasim.makePayment(card2);
        
        Qasim.addPaymentMethod(cash2);
        //Qasim.makePayment(cash2);
    	
        Qasim.addPaymentMethod(op);
        //Qasim.makePayment(op);
        
        System.out.println();
        System.out.println("Amount After payment: "+card2.getAmount());
        //System.out.println("Amount After payment: "+cash2.getAmount());
        //System.out.println("Amount After payment: "+op.getAmount());
        
    	daraz.showInventory();
    }
      
}
