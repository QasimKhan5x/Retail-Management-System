package com.company;

//Complete

public class Item {
    private static int ids = 0;
    private final int id;
    private final String name;
    private final double price;

    public Item(String name, double price) {
        this.id = ++ids;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("ID: %d. Name: %s. Price: %.2f.", id, name, price);
    }
}