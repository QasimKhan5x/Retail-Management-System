package Orders;
//Complete
public class OrderDetails {
    private final int orderID;
    private final int quantity;

    public OrderDetails(int orderID, int quantity) {
        this.orderID = orderID;
        this.quantity = quantity;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("Order ID: %.2f. Quantity: %.2f", orderID, quantity);
    }
}
