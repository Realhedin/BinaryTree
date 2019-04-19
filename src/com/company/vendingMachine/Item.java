package com.company.vendingMachine;

/**
 * @author dkorolev
 *         Date: 3/21/2019
 *         Time: 5:38 PM
 */
public enum Item {
    COKE(25),
    PEPSI(25),
    SODA(45);

    private int price;

    Item(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}