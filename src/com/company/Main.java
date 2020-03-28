package com.company;

import Payments.*;
import Shops.*;
import com.company.*;

//changes nee to pull on github
import java.util.ArrayList;

public class Main {
	
    public static void main(String[] args) {
 
    	
    	Outlet nustbackers=new Outlet("Nust Backers",2000,"Concordia 2");
    	
    	Item chocolate=new Item("Kitkat",100);
    	Item milk=new Item("Prema Milk",150);
    	Item sweets = new Item("Cake",500);
    	Item chips= new Item("Lays",50);
    	Item biscut= new Item("Cocomo",10);
    	
    	
    	nustbackers.addItem(milk,15);
    	nustbackers.addItem(chips,20);
    	nustbackers.addItem(biscut,10);
       	nustbackers.addItem(chocolate,25);
    	nustbackers.addItem(sweets,5);
    	//nustbackers.addItem(milk,10);

    	Customer Samad=new Customer("Abdul Smaad","3003420840",nustbackers);
    	
    	Samad.addToCart(milk, 2);
    	Samad.addToCart(chips, 4);
    	Samad.addToCart(sweets, 1);
    	Samad.addToCart(chocolate, 5);
    	//Samad.printBill();
    	
    	//System.out.println("Inventory before payment");
    	//System.out.println(nustbackers.getInventory());
    	
 
    	
    	Card card = new Card();
    	Cash cash = new Cash();
    	
        card.addAmount(25000);
        cash.addAmount(20000);
        
       //	System.out.println("Amount before payment: "+card.getAmount());
       	System.out.println("Amount before payment: "+cash.getAmount());
       	
        Samad.addPaymentMethod(cash);
        Samad.makePayment(cash);
        
        //System.out.println("Amount After payment: "+card.getAmount());
        System.out.println("Amount After payment: "+cash.getAmount());
        System.out.println();
        //System.out.println("Inventory After payment");
    	//System.out.println(nustbackers.getInventory());
    	
    
    	
    	
    /*	
    	//online store demo
    	OnlineStore daraz=new OnlineStore("Daraz",4000,"daraz.com.pk");
    	
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
    	
    	Customer Qasim=new Customer("Qasim Khan", "123456789", daraz);
    	
    	Qasim.addToCart(chair, 2);
        Qasim.addToCart(jacket, 3);
        Qasim.addToCart(table, 1);
        Qasim.addToCart(book, 1);
        

    //	System.out.println(daraz.getInventory());
       
    	Card card2 = new Card();
    	Cash cash2 = new Cash();
    	OnlinePayment os2= new OnlinePayment();
    	
        card2.addAmount(50000);
        cash2.addAmount(40000);
        os2.addAmount(30000);
        System.out.println("Amount Before payment: "+card2.getAmount());
       // System.out.println("Amount Before payment: "+cash2.getAmount());
       // System.out.println("Amount Before payment: "+os2.getAmount());
        
        
   //     payments methods demo
        Qasim.addPaymentMethod(card2);
        Qasim.makePayment(card2);
        
        //Qasim.addPaymentMethod(cash2);
        //Qasim.makePayment(cash2);
    	
       // Qasim.addPaymentMethod(os2);
       // Qasim.makePayment(os2);
        
        System.out.println();
        System.out.println("Amount After payment: "+card2.getAmount());
        //System.out.println("Amount After payment: "+cash2.getAmount());
        //System.out.println("Amount After payment: "+os2.getAmount());
        
    //	System.out.println(daraz.getInventory());
      */ 
    }
      
}
