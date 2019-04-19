package com.company.cglib;

/**
 * @author dkorolev
 *         Date: 4/4/2019
 *         Time: 4:32 PM
 */
public class PersonalServiceImpl implements PersonalService {

    @LazyString
    public String sayHello(String name) {
        return "Hello " + name;
    }

    public Integer lengthOfName(String name) {
        return name.length();
    }
}