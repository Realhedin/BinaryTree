package com.company.objOrientedAnalysisAndDesign.atm;

import java.util.Map;

/**
 * @author dkorolev
 *         Date: 5/20/2019
 *         Time: 11:06 AM
 */
public class WithdrawBanknots {

    private boolean enoughMoneyInATM;

    private Map<Banknot,Integer> banknotsToWithdraw;


    public WithdrawBanknots(boolean enoughMoneyInATM, Map<Banknot, Integer> banknotsToWithdraw) {
        this.enoughMoneyInATM = enoughMoneyInATM;
        this.banknotsToWithdraw = banknotsToWithdraw;
    }

    public boolean isEnoughMoneyInATM() {
        return enoughMoneyInATM;
    }

    public void setEnoughMoneyInATM(boolean enoughMoneyInATM) {
        this.enoughMoneyInATM = enoughMoneyInATM;
    }

    public Map<Banknot, Integer> getBanknotsToWithdraw() {
        return banknotsToWithdraw;
    }

    public void setBanknotsToWithdraw(Map<Banknot, Integer> banknotsToWithdraw) {
        this.banknotsToWithdraw = banknotsToWithdraw;
    }
}