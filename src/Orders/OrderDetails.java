package Orders;

import java.util.Objects;

public class OrderDetails {
    private static int IDs = 0;
    private final int orderID;
    private int quantity;

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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetails that = (OrderDetails) o;
        return quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }

    @Override
    public String toString() {
        return String.format("Order ID: %d. Quantity: %d", orderID, quantity);
    }
}
