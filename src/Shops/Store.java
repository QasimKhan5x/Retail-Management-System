package Shops;

import com.company.Item;

import java.util.HashMap;


abstract public class Store {
    protected static String name;
    private String address;
    protected static double register;
    protected static HashMap<Item, Integer> inventory = new HashMap<>();

    public Store(String address) {
        this.address = address;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String storeName) {
        name = storeName;
    }

    public static double getRegister() {
        return register;
    }

    public static void setRegister(double amount) {
        register = amount;
    }

    public static HashMap<Item, Integer> getInventory() {
        return inventory;
    }

    public static void setInventory(HashMap<Item, Integer> Inventory) {
        inventory = Inventory;
    }

    public static void showInventory() {
        String str = "The store " + name + " has the following items:\n";
        for(Item item : inventory.keySet()) {
            str += item + " Quantity: " + inventory.get(item) + "\n";
        }
        System.out.print(str);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void addItem(Item item, int quantity) {
        if (inventory.containsKey(item))
            inventory.replace(item, inventory.get(item) + quantity);
        else
            inventory.put(item, quantity);
    }

    public static void addItem(Item item) {
    	 changeItemQuantity(item, 1);
    }

    public static void changeItemQuantity(Item item, int amount) {
        inventory.replace(item, inventory.get(item) + amount);
        if (inventory.get(item) <= 0) inventory.remove(item);
    }

    @Override
    public String toString() {
        return name;
    }
}
