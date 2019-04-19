package com.company.complexSearchReduce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/**
 * @author dkorolev
 *         Date: 3/4/2019
 *         Time: 4:06 PM
 */
public class ComplexSearchReduce {

    public static void main(String[] args) {

        //list of connections
        List<Connection> network = Arrays.asList(new Connection("A", "B"),
                new Connection("A", "C"),
                new Connection("A", "D"),
                new Connection("B", "C"));


        //identity
        List<String> identity = new ArrayList<>();

        //accumulator
        BiFunction<List<String>, Connection, List<String>> accumulator = (strings, connection) -> {
            strings.add(connection.getTo());
            return strings;
        };

        //combiner
        BinaryOperator<List<String>> combiner = (strings, strings2) -> {
            strings.addAll(strings2);
            return strings;
        };


        //use reduce to find all connections from "A"
        List<String> list = network.stream()
                .filter(p -> "A".equals(p.getFrom()))
                .reduce(identity, accumulator, combiner);
        System.out.println(list);


    }
}