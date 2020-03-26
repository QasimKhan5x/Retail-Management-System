package Orders;

import com.company.Item;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Order {
    private HashMap<Item, OrderDetails> details;
    private double totalPrice = 0;
    private static int idTotal = 0;
    private final int id;
    private final LocalDateTime receiveDate;

    public Order(HashMap<Item, OrderDetails> details) {
        this.id = ++idTotal;
        this.details = details;
        this.receiveDate = LocalDateTime.now();
        for(Item item : details.keySet())
            totalPrice += item.getPrice();
    }

    public Order() {
        this(new HashMap<>());
    }

    public HashMap<Item, OrderDetails> getDetails() {
        return details;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getId() {
        return this.id;
    }

    public LocalDateTime getReceiveDate() {
        return this.receiveDate;
    }

    public void addItem(Item item, int quantity) {
        OrderDetails orderDetails = new OrderDetails(quantity);
        details.put(item, orderDetails);
        totalPrice += item.getPrice() * quantity;
    }

    public void printOrders() {
        for(Item item : details.keySet()) {
            System.out.println(details.get(item) + " " + item);
        }
        System.out.printf("Total Price: %.2f", this.getTotalPrice());
    }
}