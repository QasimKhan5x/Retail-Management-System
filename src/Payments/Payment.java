package Payments;

import java.time.LocalDateTime;

abstract public class Payment {
    private final String id;
    private final LocalDateTime date;
    private final double amount;

    public Payment(String id, LocalDateTime date, double amount) {
        this.id = id;
        this.date = date;
        this.amount = amount;
    }

    public Payment() {
        this(null, LocalDateTime.now(), 0);
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }
}
