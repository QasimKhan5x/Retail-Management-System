package Shops;

//Complete
import com.company.Item;

import java.util.HashMap;

abstract public class Store {
    private final String name;
    private final String address;
    private HashMap<Item, Integer> inventory;

    public Store(String name, String address, HashMap<Item, Integer> inventory) {
        this.name = name;
        this.address = address;
        this.inventory = inventory;
    }

    public Store() {
        this(null, null, new HashMap<>());
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
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

    public void addItem(Item item) {
        this.addItem(item, 1);
    }

    public void changeItemQuantity(Item item, int amount) {
        inventory.replace(item, inventory.get(item) + amount);
    }
}
