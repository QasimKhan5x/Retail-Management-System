package Shops;

import com.company.Item;

import java.util.HashMap;


abstract public class Store {
    private String name;
    private double register;
    
    private HashMap<Item, Integer> inventory;

    public Store(String name, double register, HashMap<Item, Integer> inventory) {
        this.name = name;
        this.register = register;
        this.inventory = inventory;
    }

    public Store(String name, double register) {
        this.name = name;
        this.register = register;
        this.inventory = new HashMap<>();
    }

    public Store() {
        this(null,0,new HashMap<>());
    }

    public double getRegister() {
        return register;
    }

    public void setRegister(double register) {
        this.register = register;
    }

    public void setInventory(HashMap<Item, Integer> inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    

    public HashMap<Item, Integer> getInventory() {
        return inventory;
    }

    public void addItem(Item item, int quantity) {
        if (inventory.containsKey(item)) {
            System.out.println("Already present in the inventory");
        } else {
            inventory.put(item, quantity);
        }
    }
   //change 
    public void addItem(Item item) {
    	 if (inventory.containsKey(item)) 
             System.out.println("Already present in the inventory");
         else
           	 this.addItem(item, 1);
   
    }

    public void changeItemQuantity(Item item, int amount) {
        inventory.replace(item, inventory.get(item) + amount);
        if (inventory.get(item) <= 0) inventory.remove(item);
    }

    @Override
    public String toString() {
        String str = "The store " + name + " has the following items:\n";
        for(Item item : inventory.keySet()) {
            str += item;
        }
        return str;
    }
}
