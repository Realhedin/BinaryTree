package com.company.streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author dkorolev
 *         Date: 5/10/2019
 *         Time: 1:46 PM
 */
public class StreamExersisesExtention {
    public static void main(String[] args) {
        Map<String, List<String>> library = new HashMap<>();
        library.put("a", Arrays.asList("aaa", "bbb"));
        library.put("c", Arrays.asList("cccc", "sssss"));
        library.put("u", Arrays.asList("ddd", "eeee"));
        List<String> collect = library.entrySet().stream()
                .filter(s -> s.getKey().equals("a") || s.getKey().equals("u"))
                .flatMap(f -> f.getValue().stream())
                .collect(Collectors.toList());
        collect.stream().forEach(System.out::println);
    }
}