package Shops;

import com.company.Item;

import java.util.HashMap;


abstract public class Store {
    private String name;
    private String address;
    private double register;
    private HashMap<Item, Integer> inventory;

    public Store(String name, String address, double register, HashMap<Item, Integer> inventory) {
        this.name = name;
        this.address = address;
        this.register = register;
        this.inventory = inventory;
    }

    public Store(String name, String address, double register) {
        this.name = name;
        this.address = address;
        this.register = register;
        this.inventory = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRegister() {
        return register;
    }

    public void setRegister(double register) {
        this.register = register;
    }

    public HashMap<Item, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(HashMap<Item, Integer> inventory) {
        this.inventory = inventory;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void showInventory() {
        String str = "The store " + name + " has the following items:\n";
        for(Item item : inventory.keySet()) {
            str += item + " Quantity: " + inventory.get(item) + "\n";
        }
        System.out.print(str);
    }

    public void addItem(Item item, int quantity) {
        if (inventory.containsKey(item))
            inventory.replace(item, inventory.get(item) + quantity);
        else
            inventory.put(item, quantity);
    }

    public void addItem(Item item) {
    	 this.changeItemQuantity(item, 1);
    }

    public void changeItemQuantity(Item item, int amount) {
        inventory.replace(item, inventory.get(item) + amount);
        if (inventory.get(item) <= 0) inventory.remove(item);
    }

    @Override
    public String toString() {
        return name;
    }
}
