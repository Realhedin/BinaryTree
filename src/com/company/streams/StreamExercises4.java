package com.company.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.company.Gender;

/**
 * @author dkorolev
 *         Date: 4/23/2019
 *         Time: 12:49 PM
 */
public class StreamExercises4 {
    public static void main(String[] args) {

        List<String> ordered = Arrays.asList("a1", "a4",  "a3", "a2", "a1", "a4");

        List<People> listPeople = Arrays.asList( new People("Вася", 16, Gender.MALE),
                new People("Петя", 23, Gender.MALE),
                new People("Елена", 42, Gender.FEMALE),
                new People("Иван Иванович", 69, Gender.MALE));


        List<String> sorted1 = ordered.stream().sorted().collect(Collectors.toList());
        sorted1.forEach(s->System.out.print(s+" "));
        System.out.println();

        List<String> sorted2 = ordered.stream().sorted((s1,s2)->s2.compareTo(s1)).collect(Collectors.toList());
        sorted2.forEach(s->System.out.print(s+" "));
        System.out.println();

        List<String> sorted3 = ordered.stream().sorted().distinct().collect(Collectors.toList());
        sorted3.forEach(s->System.out.print(s+" "));
        System.out.println();

        List<String> sorted4 = ordered.stream().sorted((s1,s2)->s2.compareTo(s1)).distinct().collect(Collectors.toList());
        sorted4.forEach(s->System.out.print(s+" "));
        System.out.println();

        List<People> sortedPeople = listPeople.stream().sorted((s1,s2)->s1.getName().compareTo(s2.getName())).collect(Collectors.toList());
        sortedPeople.forEach(s->System.out.print(s.getName()+" "));
        System.out.println();

        List<People> sortedPeople2 = listPeople.stream()
                .sorted((s1,s2)->s1.getGender().compareTo(s2.getGender()))
                .sorted((s1,s2)-> s1.getAge() > s2.getAge() ? s1.getAge() : s2.getAge()).collect(Collectors.toList());
        sortedPeople2.forEach(s->System.out.print(s.getName()+" "));
        System.out.println();
    }
}