package com.company.streams;

import java.util.Arrays;
import java.util.List;

import com.company.Gender;

/**
 * @author dkorolev
 *         Date: 4/23/2019
 *         Time: 1:22 PM
 */
public class StreamExercises5 {
    public static void main(String[] args) {
        List<String> ordered = Arrays.asList("a1", "a2",  "a3", "a1");

        List<People> listPeople = Arrays.asList( new People("Вася", 16, Gender.MALE),
                new People("Петя", 23, Gender.MALE),
                new People("Елена", 42, Gender.FEMALE),
                new People("Иван Иванович", 69, Gender.MALE));

        String s = ordered.stream().max(String::compareTo).orElse("-1");
        System.out.println(s);

        String min = ordered.stream().min(String::compareTo).orElse("-1");
        System.out.println(min);

        People maxAgePerson = listPeople.stream().max((s1,s2)-> s1.getAge().compareTo(s2.getAge())).get();
        System.out.println(maxAgePerson.getName());

        People minAgePerson = listPeople.stream().max((s1,s2)-> s2.getAge().compareTo(s1.getAge())).get();
        System.out.println(minAgePerson.getName());
    }
}