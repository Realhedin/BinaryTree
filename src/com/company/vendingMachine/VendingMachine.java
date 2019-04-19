package com.company.vendingMachine;

import java.util.List;

/**
 * @author dkorolev
 *         Date: 3/21/2019
 *         Time: 5:40 PM
 */
public interface VendingMachine {

    //add coin into vending machine
    void putCoin(Coin coin);

    //try to buy a product
    Boolean buyProduct(List<Coin> summ, Item item);

    //give change to customer
    List<Coin> giveChange(List<Coin> change);





}