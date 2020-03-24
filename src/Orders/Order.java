package Orders;

import com.company.Item;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Order {
    private HashMap<Item, OrderDetails> order;
    private double totalPrice = 0;
    private final int id;
    private final LocalDateTime receiveDate;

    public Order(HashMap<Item, OrderDetails> order, int id, LocalDateTime receiveDate) {
        this.id = id;
        this.order = order;
        this.receiveDate = receiveDate;
        for(Item item : order.keySet()) {
            totalPrice += item.getPrice();
        }
    }

    public Order() {
        this(new HashMap<>(), 0, LocalDateTime.now());
    }

    public HashMap<Item, OrderDetails> getOrder() {
        return order;
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

    public void printOrders() {
        for(Item item : order.keySet()) {
            System.out.println(order.get(item) + " " + item);
        }
        System.out.printf("Total Price: %.2f", this.getTotalPrice());
    }
}