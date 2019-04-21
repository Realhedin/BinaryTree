package com.company.streams;

import com.company.Gender;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dkorolev on 4/21/2019.
 */
public class StreamExercises2 {

    public static void main(String[] args) {
        List<People> listPeople = Arrays.asList( new People("Вася", 16, Gender.MALE),
                new People("Петя", 23, Gender.MALE),
                new People("Елена", 42, Gender.FEMALE),
                new People("Иван Иванович", 69, Gender.MALE));

        List<People> fightPeople = listPeople.stream().filter(s1 -> s1.getGender() == Gender.MALE)
                .filter(s1 -> 18 <= s1.getAge() && s1.getAge() <= 27)
                .collect(Collectors.toList());
        fightPeople.forEach(s1-> System.out.print(s1.getName()));
        System.out.println();

        double asDouble = listPeople.stream().filter(s1 -> s1.getGender() == Gender.MALE)
                .mapToInt(People::getAge).average().getAsDouble();
        System.out.println(asDouble);

        long count = listPeople.stream().filter(s1 -> s1.getGender() == Gender.MALE && 18 <= s1.getAge() && s1.getAge() <= 60
                || s1.getGender() == Gender.FEMALE && 18 <= s1.getAge() && s1.getAge() <= 55).count();
        System.out.println(count);
    }
}
