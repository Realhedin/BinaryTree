package com.company.goldmanSachsInterview;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author dkorolev
 *         Date: 4/16/2019
 *         Time: 11:55 AM
 */
public class BestAverageScoreTest {

    @Test
    public void averageValue() {
        String array[][] =  {{"Name1","80"},{"Name2","67"}, {"Name1","60"}};
        Pair<String, Double> actualValues = BestAverageScore.averageValue(array);
        Assert.assertEquals(new Pair<>("Name1",70d),actualValues);
    }


    @Test
    public void averageValue_2() {
        String array[][] =  {{"Name1","80"},{"Name2","50"}, {"Name1","60"}, {"Name2","100"}, {"Name3","71"}, {"Name3","81"}};
        Pair<String, Double> actualValues = BestAverageScore.averageValue(array);
        Assert.assertEquals(new Pair<>("Name3",76d),actualValues);
    }
}