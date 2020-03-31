package com.company;

import Payments.Card;
import Payments.Cash;
import Payments.OnlinePayment;
import Payments.Payment;
import Shops.OnlineStore;
import Shops.Outlet;
import Shops.Store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Customer customer;
    private OnlineStore onlineStore;
    private Outlet outlet;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        createStore();
        createCustomer();
        addCustomerPaymentMethods();
        boolean shopAgain = true;
        while (shopAgain) {
            createOrder();
            Payment payment = choosePayment();
            boolean success = placeOrder(payment);
            while (!success) {
                boolean exit = false;
                System.out.println("You can try any of the following:");
                System.out.println("1. Add balance to your current payment method");
                System.out.println("2. Change your payment method");
                System.out.println("3. Change your order");
                System.out.println("4. Exit the store");
                System.out.println("Pick one of the above numbers.");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1: {
                        System.out.println("How much do you want to add?");
                        double amount = scanner.nextDouble();
                        payment.addAmount(amount);
                        System.out.println("Processing your order again");
                        success = placeOrder(payment);
                        break;
                    }
                    case 2: {
                        payment = choosePayment();
                        System.out.println("Processing your order again");
                        success = placeOrder(payment);
                        break;
                    }
                    case 3: {
                        createOrder();
                        payment = choosePayment();
                        System.out.println("Processing your order again");
                        success = placeOrder(payment);
                        break;
                    }
                    case 4: {
                        exit = true;
                        break;
                    }
                    default:
                        System.out.println("Invalid choice");
                }
                if (exit) break;
            }
            System.out.println("Do you want to shop again?\nPress Enter to shop again or " +
                    "Type \"no\" otherwise");
            String again = scanner.nextLine();
            if (again.equals("no"))
                shopAgain = false;
            else {
                System.out.println("How would you like to shop today?\n" +
                        "Choose either \"online\" or \"outlet\"");
                String choice = scanner.nextLine();
                while (!choice.equals("online") && !choice.equals("outlet")) {
                    System.out.println("Invalid option. Choose again");
                    choice = scanner.nextLine();
                }
                if (choice.equals("online"))
                    customer.visitStore(onlineStore);
                else
                    customer.visitStore(outlet);
            }
        }

    }

    public void createCustomer() {
        System.out.println("****************************************************");
        System.out.println("Welcome to " + Store.getName());
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        System.out.println("How would you like to shop today?\n" +
                "Choose either \"online\" or \"outlet\"");
        String choice = scanner.nextLine();
        while (!choice.equals("online") && !choice.equals("outlet")) {
            System.out.println("Invalid option. Choose again");
            choice = scanner.nextLine();
        }
        if (choice.equals("online"))
            customer = new Customer(name, "04532094", onlineStore);
        else
            customer = new Customer(name, "04532094", outlet);
        System.out.println("****************************************************");
    }

    public void createStore() {
        System.out.println("****************************************************");
        System.out.println("Hello! What is your store's name?");
        Store.setName(scanner.nextLine());
        System.out.println("How much balance does your store have in its register?");
        Store.setRegister(Double.parseDouble(scanner.nextLine()));
        System.out.println("What is your outlet's cashier's name?");
        String cashier = scanner.nextLine();
        System.out.println("What is your outlet's address?");
        String address = scanner.nextLine();
        System.out.println("What is the url of your store's website?");
        String url = scanner.nextLine();
        System.out.println("Add an inventory to your store.");
        HashMap<Item, Integer> inventory = new HashMap<>();
        boolean keepAdding = true;
        while (keepAdding) {
            System.out.println("Do you want to add another item? Enter \"exit\" to stop or \"add\" to add an item");
            String choice = scanner.nextLine();
            switch (choice) {
                case "exit": keepAdding = false; break;
                case "add": {
                    System.out.println("Enter item name");
                    String name = scanner.nextLine();
                    System.out.println("Enter a " + name + "'s price");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter quantity");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    Item item = new Item(name, price);
                    inventory.put(item, quantity);
                    break;
                }
                default: System.out.println("Invalid choice. Enter again");
            }
        }
        Store.setInventory(inventory);
        onlineStore = new OnlineStore(url);
        outlet = new Outlet(address, cashier);
        System.out.println("Stores have been created successfully");
        System.out.println("****************************************************");
    }

    public void addCustomerPaymentMethods() {
        System.out.println("****************************************************");
        System.out.println("Enter the payment methods you want");
        ArrayList<String> methods = new ArrayList<>();
        while (methods.size() < 3) {
            double amount;
            System.out.println("Do you want a card, cash, or online payment account? Enter \"exit\" to stop\n" +
                    "(Enter \"card\", \"cash\", or \"online\")");
            String choice = scanner.nextLine();
            if (methods.contains(choice)) {
                System.out.println("You have already added that method");
            } else if (choice.equals("exit"))
                break;
            else {
                switch (choice) {
                    case "card": {
                        methods.add(choice);
                        System.out.println("Enter amount to deposit in your card");
                        amount = Double.parseDouble(scanner.nextLine());
                        customer.addPaymentMethod(new Card(amount, customer));
                        System.out.println("Successfully added a card to your payment methods");
                        break;
                    }
                    case "cash": {
                        methods.add(choice);
                        System.out.println("Enter amount of cash to put in your wallet");
                        amount = Double.parseDouble(scanner.nextLine());
                        customer.addPaymentMethod(new Cash(amount));
                        System.out.println("Successfully created your wallet");
                        break;
                    }
                    case "online": {
                        methods.add(choice);
                        System.out.println("Enter amount to add in your account");
                        amount = Double.parseDouble(scanner.nextLine());
                        System.out.println("Enter your email");
                        String email = scanner.nextLine();
                        System.out.println("Enter your password");
                        String password = scanner.nextLine();
                        customer.addPaymentMethod(new OnlinePayment(amount, email, password));
                        System.out.println("Successfully created your online account");
                        break;
                    }
                    default:
                        System.out.println("Invalid choice");
                }
            }
        }
        System.out.println("****************************************************");
    }

    public void createOrder() {
        System.out.println("****************************************************");
        System.out.println("The store has the following items");
        Store.showInventory();
        System.out.println("Add items to your cart. Enter \"add\" to add an item or \"exit\" to checkout");
        while (true) {
            String choice = scanner.nextLine();
            if (choice.equals("exit")) break;
            if (!choice.equals("add")) {
                System.out.println("Invalid choice. Enter again");
                continue;
            }
            Item product = null;
            boolean found = false;
            String name = null;
            double price = 0;
            int quantity = 0;
            while (!found) {
                System.out.println("Enter name of item");
                name = scanner.nextLine();
                for(Item item : Store.getInventory().keySet()) {
                    if (item.getName().equals(name)) {
                        found = true;
                        price = item.getPrice();
                        product = item;
                        break;
                    }
                }
                if (!found)
                    System.out.println("The store doesn't have that item.");
            }
            boolean sufficient = false;
            while (!sufficient) {
                System.out.println("Enter the quantity you need");
                quantity = Integer.parseInt(scanner.nextLine());
                if (quantity > Store.getInventory().get(product))
                    System.out.println("The store doesn't have that quantity.");
                else
                    sufficient = true;
            }
            customer.addToCart(product, quantity);
            System.out.println("Successfully added " + product);
            System.out.println("Enter \"add\" to add another item or \"exit\" to checkout");
        }
        System.out.println("****************************************************");
    }

    public Payment choosePayment() {
        System.out.println("What do you want to pay with?");
        if (customer.getStoreVisited() instanceof Outlet) {
            System.out.println("Available options \"card\" and \"cash\"");
        } else
            System.out.println("Available options \"card\" and \"online\"");
        String choice = scanner.nextLine();
        Payment paymentType = null;
        boolean found = false;
        while (!found) {
            switch (choice) {
                case "card": {
                    for(Payment payment : customer.getPaymentMethods()) {
                        if (payment instanceof Card) {
                            paymentType = payment;
                            found = true;
                        }
                    }
                    break;
                }
                case "cash": {
                    for(Payment payment : customer.getPaymentMethods()) {
                        if (payment instanceof Cash) {
                            paymentType = payment;
                            found = true;
                        }
                    }
                    break;
                }
                case "online": {
                    for(Payment payment : customer.getPaymentMethods()) {
                        if (payment instanceof OnlinePayment) {
                            paymentType = payment;
                            found = true;
                        }
                    }
                    break;
                }
                default:
                    System.out.println("Invalid choice");
            }
        }
        return paymentType;
    }

    public boolean placeOrder(Payment paymentType) {
        if (!customer.canMakePayment(paymentType))
            return false;
        else {
            customer.makePayment(paymentType);
            return true;
        }
    }

}
