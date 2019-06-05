package com.company.objOrientedAnalysisAndDesign.atm;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dkorolev
 *         Date: 5/18/2019
 *         Time: 8:42 PM
 */
public class ATM {

    private static final int MAX_PIN_TRY = 3;

    private Map<Banknot, Integer> numberOfBanknotsInAtm;
    private CardStatus cardStatus;



    public ATM(Map<Banknot, Integer> numberOfBanknotsInAtm) {
        this.numberOfBanknotsInAtm = numberOfBanknotsInAtm;
    }

    public void insertCard(Card card) {
        if (cardStatus != null) {
            if (cardStatus.isCardBlocked()) {
                cardStatus = null;
            }
        }
        if (cardStatus == null) {
            cardStatus = new CardStatus();
            cardStatus.setCurrentCardInserted(card);
        } else {
            System.err.println("Another card is already inserted");
        }
    }

    public void pullOutCard() {
        if (!cardStatus.isCardBlocked()) {
            cardStatus = null;
        } else {
            System.err.println("Too many PIN attemps. Card was blocked.");
        }
    }

    public boolean enterPIN(int pin) {
        if (cardStatus != null) {
            if (pin == cardStatus.getCurrentCardInserted().getPin()) {
                cardStatus.setVerified(true);
                return true;
            } else {
                cardStatus.setPinVerifiedTry(cardStatus.getPinVerifiedTry()+1);
                if (cardStatus.getPinVerifiedTry() >= MAX_PIN_TRY) {
                    cardStatus.setCardBlocked(true);
                    System.err.println("Too many PIN attemps. Card was blocked.");
                    return false;
                }
                System.err.println("You have left " + (MAX_PIN_TRY - cardStatus.getPinVerifiedTry()) + " attempts");
                return false;
            }
        } else {
            System.err.println("No card in ATM");
            return false;
        }
    }


    public int showBalance() {
        if (cardStatus.isVerified()) {
            return cardStatus.getCurrentCardInserted().getSumOfMoney();
        } else {
            throw new RuntimeException("User is not authorized");
        }
    }


    public boolean cashIn(List<Banknot> banknotList) {
        if (cardStatus.isVerified()) {
            int sumOfMoney = calculateAmountOfBanknots(banknotList);
            cardStatus.getCurrentCardInserted().addMoney(sumOfMoney);
            addBanknotsToMap(banknotList);
            return true;
        } else {
            throw new RuntimeException("User is not authorized");
        }
    }




    public Map<Banknot, Integer> withdrawMoney(int sumOfMOney) {
        if (cardStatus.isVerified()) {
            WithdrawBanknots booleanMapPair = checkEnoughMoneyInATM(sumOfMOney);
            if (booleanMapPair.isEnoughMoneyInATM()) {
                boolean operationResult  = cardStatus.getCurrentCardInserted().withdrawMoney(sumOfMOney);
                if (operationResult) {
                    return booleanMapPair.getBanknotsToWithdraw();
                } else {
                   throw  new RuntimeException("Not enough money on account");
                }
            } else {
               throw  new RuntimeException("Not enough money in ATM");
            }
        } else {
            throw new RuntimeException("User is not verified");
        }
    }






    private int calculateAmountOfBanknots(List<Banknot> banknotList) {
        return banknotList.stream().mapToInt(Banknot::getDenomination).sum();
    }

    private void addBanknotsToMap(List<Banknot> banknotList) {
        for (Banknot banknot : banknotList) {
            Integer denom = numberOfBanknotsInAtm.get(banknot);
            if (denom == null) {
                numberOfBanknotsInAtm.put(banknot, 1);
            } else {
                numberOfBanknotsInAtm.replace(banknot, denom + 1);
            }

        }
    }

    private WithdrawBanknots checkEnoughMoneyInATM(int sumOfMOney) {
        Map<Banknot, Integer> banknotToUseForWithdrawn = new HashMap<>();
        sumOfMOney = handleBanknots(sumOfMOney, 1, banknotToUseForWithdrawn, Banknot.FIVE_THOUSAND);
        sumOfMOney = handleBanknots(sumOfMOney, 1, banknotToUseForWithdrawn, Banknot.THOUSAND);
        sumOfMOney = handleBanknots(sumOfMOney, 1, banknotToUseForWithdrawn, Banknot.FIVE_HUNDRED);
        sumOfMOney = handleBanknots(sumOfMOney, 1, banknotToUseForWithdrawn, Banknot.HUNDRED);
        if (sumOfMOney ==0) {
            deductMoneyFromATM(banknotToUseForWithdrawn);
            return new WithdrawBanknots(true, banknotToUseForWithdrawn);
        }
        return new WithdrawBanknots(false, Collections.emptyMap());
    }


    //calculate if we can handle with definitive banknot type
    private int handleBanknots(int sumOfMoney, int numOfBanknots,
                               Map<Banknot, Integer> banknotToUseForWithdrawn, Banknot banknotType) {
        if (sumOfMoney > banknotType.getDenomination()) {
            while (sumOfMoney / (numOfBanknots * banknotType.getDenomination())
                    > banknotType.getDenomination()
                    && numberOfBanknotsInAtm.get(banknotType) >= numOfBanknots) {
                numOfBanknots++;
            }
            banknotToUseForWithdrawn.put(banknotType, --numOfBanknots);
            sumOfMoney -= banknotType.getDenomination()*numOfBanknots;
        }
        return sumOfMoney;
    }



    private void deductMoneyFromATM(Map<Banknot, Integer> banknotToUseForWithdrawn) {
        for (Map.Entry<Banknot, Integer> banknotIntegerEntry : banknotToUseForWithdrawn.entrySet()) {
            Integer curNumberExistedBanknots = numberOfBanknotsInAtm.get(banknotIntegerEntry.getKey());
            numberOfBanknotsInAtm.replace(banknotIntegerEntry.getKey(), curNumberExistedBanknots -
                    banknotIntegerEntry.getValue());
        }
    }
}