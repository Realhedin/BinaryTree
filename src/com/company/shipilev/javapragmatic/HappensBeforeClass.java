package com.company.shipilev.javapragmatic;


/**
 * Possible values for r1 and r2:
 * 1:1, 0:0 and 0:1
 */
public class HappensBeforeClass {

    int x;
    volatile int g;


    public void settingFunction() {
        x=1;
        g=1;
    }

    public void gettingFunction() {
        int r1 = g;
        int r2 = x;
        System.out.print("r1:"+r1);
        System.out.print("r2:"+r2);
        System.out.print(" ");
    }

}
