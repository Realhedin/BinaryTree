package com.company.vendingMachine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


/**
 * @author dkorolev
 *         Date: 3/22/2019
 *         Time: 4:51 PM
 */
public class VendingMachineImplTest {

    private VendingMachineImpl vendingMachine;
    private List<Coin> expCoins;


    @Before
    public void init() {
        vendingMachine = new VendingMachineImpl();
        vendingMachine.summOfInputCoins.add(Coin.QUARTER);
        vendingMachine.summOfInputCoins.add(Coin.QUARTER);
        vendingMachine.summOfInputCoins.add(Coin.DIME);
        vendingMachine.summOfInputCoins.add(Coin.PENNY);
        vendingMachine.summOfInputCoins.add(Coin.PENNY);

        expCoins = new ArrayList<>();
        expCoins.add(Coin.QUARTER);
        expCoins.add(Coin.DIME);
        expCoins.add(Coin.PENNY);
        expCoins.add(Coin.PENNY);
    }


    @Test
    public void calculateSumTest1() {
        int sum = vendingMachine.calculateSum(vendingMachine.summOfInputCoins);
        assertTrue(sum>0);
        assertEquals(57,sum);
    }

    @Test
    public void fillTheChangeTest() {
        List<Coin> coins = vendingMachine.fillTheChange(32);
        assertNotNull(coins);
        assertEquals(expCoins,coins);
    }

    @Test
    public void buyProductTest() {
        Boolean aBoolean = vendingMachine.buyProduct(vendingMachine.summOfInputCoins, Item.COKE);
        assertTrue(aBoolean);
        assertEquals(32,vendingMachine.calculateSum(vendingMachine.summOfInputCoins));
        assertEquals(expCoins,vendingMachine.summOfInputCoins );
    }

}