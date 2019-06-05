package com.company.objOrientedAnalysisAndDesign.atm;

/**
 * @author dkorolev
 *         Date: 5/18/2019
 *         Time: 9:26 PM
 */
public class Card {

    private long cardNum;
    private int pin;
    private int sumOfMoney;


    public boolean addMoney(int sumOfMoney) {
        //transaction to bank with cardNum
        this.sumOfMoney += sumOfMoney;
        return true;
    }

    public boolean withdrawMoney(int sumOfMoney) {
        if (this.getSumOfMoney() > sumOfMoney) {
            //call transaction to banc account
            this.sumOfMoney -= sumOfMoney;
            return true;
        } else {
            return false;
        }
    }


    public long getCardNum() {
        return cardNum;
    }

    public int getPin() {
        return pin;
    }

    public int getSumOfMoney() {
        return sumOfMoney;
    }
}