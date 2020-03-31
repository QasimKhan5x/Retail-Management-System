package Orders;

public class OrderDetails {
    private static int IDs = 0;
    private final int orderID;
    private final int quantity;

    public OrderDetails(int quantity) {
        this.orderID = ++IDs;
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
        return String.format("Order ID: %d. Quantity: %d", orderID, quantity);
    }
}
