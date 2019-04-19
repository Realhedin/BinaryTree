package com.company.vendingMachine;

/**
 * @author dkorolev
 *         Date: 3/21/2019
 *         Time: 5:34 PM
 */
public enum Coin {
    PENNY(1),
    DIME(5),
    NICKEL(10),
    QUARTER(25);

    private int demonination;

    Coin(int demonination) {
        this.demonination = demonination;
    }


    public int getDemonination() {
        return demonination;
    }
}
