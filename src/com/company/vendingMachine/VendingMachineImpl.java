package com.company.vendingMachine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dkorolev
 *         Date: 3/22/2019
 *         Time: 4:14 PM
 */
public class VendingMachineImpl implements VendingMachine {

    private final int MAX = 10;

    List<Coin> summOfInputCoins = new ArrayList<>();


    @Override
    public void putCoin(Coin coin) {
        summOfInputCoins.add(coin);
    }

    @Override
    public Boolean buyProduct(List<Coin> summ, Item item) {
        int summOfCoins = calculateSum(summ);
        if (item.getPrice() <= summOfCoins) {
            summOfInputCoins.clear();
            summOfInputCoins = fillTheChange(summOfCoins - item.getPrice());
        } else {
            System.err.println("Not enough money");
        }
        return Boolean.TRUE;
    }


    @Override
    public List<Coin> giveChange(List<Coin> change) {
        return change;
    }



    //helpers
    protected int calculateSum(List<Coin> summ) {
//        return summ.stream().mapToInt(Coin::getDemonination).sum();
        return summ.stream().map(Coin::getDemonination).reduce(0, (s1, s2) -> s1 + s2);
    }


    protected List<Coin> fillTheChange(int diffForChange) {
        List<Coin> coins = new ArrayList<>();
        diffForChange = reduceCoinFromChange(diffForChange, coins, Coin.QUARTER);
        if (diffForChange > 0) {
            diffForChange = reduceCoinFromChange(diffForChange, coins, Coin.NICKEL);
        }
        if (diffForChange > 0) {
            diffForChange = reduceCoinFromChange(diffForChange, coins, Coin.DIME);
        }
        if (diffForChange > 0) {
            reduceCoinFromChange(diffForChange, coins, Coin.PENNY);
        }
        return coins;
    }

    private int reduceCoinFromChange(int diffForChange, List<Coin> coins, Coin coin) {
        for (int i = 1; i < MAX; i++) {
            if (diffForChange - coin.getDemonination() * i < 0) {
                //change is less than a coin denomination
                if (i == 1) {
                    break;
                } else {
                    for (int j = 1; j < i; j++) {
                        coins.add(coin);
                        diffForChange -= coin.getDemonination();
                    }
                    return diffForChange;
                }
            }
        }
        return diffForChange;
    }


}