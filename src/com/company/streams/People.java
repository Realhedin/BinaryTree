package com.company.streams;

import com.company.Gender;

/**
 * Created by dkorolev on 4/21/2019.
 */
public class People {

    private String name;

    private int age;

    private Gender gender;


    public People(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


    //gettters & setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
