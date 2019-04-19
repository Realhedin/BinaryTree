package com.company.stringInvertion;

/**
 * @author dkorolev
 *         Date: 3/4/2019
 *         Time: 7:20 PM
 */
public class InvertStringMain {
    public static void main(String[] args) {

        String testString = "Hello, my name is Dmitrii";
        System.out.println(testString);

        InvertStringWithWhitespaces invertStringWithWhitespaces = new InvertStringWithWhitespaces();
        String s = invertStringWithWhitespaces.invertStringWithWhitespaces(testString);
        System.out.println(s);

    }
}