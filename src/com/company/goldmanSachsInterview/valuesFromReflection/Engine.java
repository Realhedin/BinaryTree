package com.company.goldmanSachsInterview.valuesFromReflection;

/**
 * @author dkorolev
 *         Date: 4/17/2019
 *         Time: 11:08 AM
 */
public class Engine {

    private int cylinder;

    private int power;


    public Engine(int cylinder, int power) {
        this.cylinder = cylinder;
        this.power = power;
    }

    public int getCylinder() {
        return cylinder;
    }

    public void setCylinder(int cylinder) {
        this.cylinder = cylinder;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}