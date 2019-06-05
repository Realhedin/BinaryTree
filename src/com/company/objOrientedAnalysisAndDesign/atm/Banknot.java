package com.company.objOrientedAnalysisAndDesign.atm;

/**
 * @author dkorolev
 *         Date: 5/18/2019
 *         Time: 8:44 PM
 */
public enum Banknot {
    HUNDRED(100),
    FIVE_HUNDRED(500),
    THOUSAND(1000),
    FIVE_THOUSAND(5000);

    private int denomination;

    Banknot(int denomination) {
        this.denomination = denomination;
    }

    public int getDenomination() {
        return denomination;
    }
}