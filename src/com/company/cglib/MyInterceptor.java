package com.company.cglib;

/**
 * @author dkorolev
 *         Date: 4/5/2019
 *         Time: 5:50 PM
 */
public class MyInterceptor {

    public String sayHello(String name) {
        return "Hello Jack";
    }

    public Integer lengthOfName(String name) {
        return name.length();
    }
}