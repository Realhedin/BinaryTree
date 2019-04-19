package com.company.goldmanSachsInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;

/**
 * @author dkorolev
 *         Date: 4/16/2019
 *         Time: 11:31 AM
 */
// O(n) + O(n) => O(n)
public class BestAverageScore {

    String array[][] =  {{"Name1","80"},{"Name2","67"}, {"Name1","60"}};



    public static Pair<String, Double> averageValue(String[][] array) {
        Map<String, List<Integer>> mapNameToValues = new HashMap<>();

        //iterate through 2nd dimention and add to map (O(n))
        for (String[] strings : array) {
            if (!mapNameToValues.containsKey(strings[0])) {
                mapNameToValues.put(strings[0], Arrays.asList(Integer.valueOf(strings[1])));
            } else {
                List<Integer> listOfMarks = new ArrayList<>(mapNameToValues.get(strings[0]));
                listOfMarks.add(Integer.valueOf(strings[1]));
                mapNameToValues.replace(strings[0], listOfMarks);
            }
        }

        //calculate averages (O(n*x), n - size of array, x - size of List of String
        double average = 0;
        String name = "";
        for (Map.Entry<String, List<Integer>> stringListEntry : mapNameToValues.entrySet()) {
            double tempAver = stringListEntry.getValue().stream().mapToInt(Integer::valueOf).average().getAsDouble();
            if (tempAver > average) {
                average = tempAver;
                name = stringListEntry.getKey();
            }
        }
        return new Pair<>(name, average);
    }
}