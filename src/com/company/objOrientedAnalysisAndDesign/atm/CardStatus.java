package com.company.objOrientedAnalysisAndDesign.atm;

/**
 * @author dkorolev
 *         Date: 5/20/2019
 *         Time: 10:10 AM
 */
public class CardStatus {

    private int pinVerifiedTry;
    private boolean isVerified;
    private boolean cardBlocked;
    private Card currentCardInserted;



    public int getPinVerifiedTry() {
        return pinVerifiedTry;
    }

    public void setPinVerifiedTry(int pinVerifiedTry) {
        this.pinVerifiedTry = pinVerifiedTry;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public boolean isCardBlocked() {
        return cardBlocked;
    }

    public void setCardBlocked(boolean cardBlocked) {
        this.cardBlocked = cardBlocked;
    }

    public Card getCurrentCardInserted() {
        return currentCardInserted;
    }

    public void setCurrentCardInserted(Card currentCardInserted) {
        this.currentCardInserted = currentCardInserted;
    }
}