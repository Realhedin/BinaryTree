package com.company.goldmanSachsInterview;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author dkorolev
 *         Date: 4/16/2019
 *         Time: 12:20 PM
 */
public class LongestDictWordsFromCharactersTest {

    @Test
    public void longestDictWords() {
        Character[] chars = {'e', 'o', 't', 's'};
        String[] dictionary = {"otse", "tse", "eo", "stoe"};
        List<String> actualResult = LongestDictWordsFromCharacters.chooseLongestWords(chars, dictionary);
        Assert.assertEquals(Arrays.asList("otse","stoe"), actualResult);
    }


    @Test
    public void chooseLongestWords() {
         String s = "abpcplea";
        List<String> dict = Arrays.asList("ale","apple","monkey","plea");
        String actual = LongestDictWordsFromCharacters.chooseLongestWords2(s, dict);
        Assert.assertEquals("apple",actual);
    }


    @Test
    public void chooseLongestWords_2() {
        String s = "abpcplea";
        List<String> dict = Arrays.asList("a","b","c");
        String actual = LongestDictWordsFromCharacters.chooseLongestWords2(s, dict);
        Assert.assertEquals("a",actual);
    }

    @Test
    public void chooseLongestWords_3() {
        String s = "bab";
        List<String> dict = Arrays.asList("ba","ab","a","b");
        String actual = LongestDictWordsFromCharacters.chooseLongestWords2(s, dict);
        Assert.assertEquals("ab",actual);
    }

    @Test
    public void chooseLongestWords_Sorting() {
        String s = "bab";
        List<String> dict = Arrays.asList("ba","ab","a","b");
        String actual = LongestDictWordsFromCharacters.chooseLongestWords3Sorting(s, dict);
        Assert.assertEquals("ab",actual);
    }


    @Test
    public void chooseLongest_Sorting2() {
        String s = "abpcplea";
        List<String> dict = Arrays.asList("ale","apple","monkey","plea");
        String actual = LongestDictWordsFromCharacters.chooseLongestWords3Sorting(s, dict);
        Assert.assertEquals("apple",actual);
    }


    @Test
    public void chooseLongest_Sorting3() {
        String s = "abpcplea";
        List<String> dict = Arrays.asList("a","b","c");
        String actual = LongestDictWordsFromCharacters.chooseLongestWords3Sorting(s, dict);
        Assert.assertEquals("a",actual);
    }


    @Test
    public void chooseLongestWords_WithoutSorting() {
        String s = "bab";
        List<String> dict = Arrays.asList("ba","ab","a","b");
        String actual = LongestDictWordsFromCharacters.chooseLongestWords4WithoutSorting(s, dict);
        Assert.assertEquals("ab",actual);
    }


    @Test
    public void chooseLongest_WithoutSorting2() {
        String s = "abpcplea";
        List<String> dict = Arrays.asList("ale","apple","monkey","plea");
        String actual = LongestDictWordsFromCharacters.chooseLongestWords4WithoutSorting(s, dict);
        Assert.assertEquals("apple",actual);
    }


    @Test
    public void chooseLongest_WithoutSorting3() {
        String s = "abpcplea";
        List<String> dict = Arrays.asList("a","b","c");
        String actual = LongestDictWordsFromCharacters.chooseLongestWords4WithoutSorting(s, dict);
        Assert.assertEquals("a",actual);
    }
}