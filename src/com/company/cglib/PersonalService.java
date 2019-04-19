package com.company.cglib;

/**
 * @author dkorolev
 *         Date: 4/5/2019
 *         Time: 5:12 PM
 */
public interface PersonalService {

    @LazyString
    public String sayHello(String name);

    public Integer lengthOfName(String name);
}