package com.company.goldmanSachsInterview.valuesFromReflection;

/**
 * @author dkorolev
 *         Date: 4/17/2019
 *         Time: 11:06 AM
 */
public class Car {

    private String color;

    private int year;

    private String mark;

    private Engine engine;


    public Car(String color, int year, String mark, Engine engine) {
        this.color = color;
        this.year = year;
        this.mark = mark;
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}