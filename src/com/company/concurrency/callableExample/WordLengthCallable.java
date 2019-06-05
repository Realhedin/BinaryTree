package com.company.concurrency.callableExample;

import java.util.concurrent.Callable;

/**
 * @author dkorolev
 *         Date: 5/23/2019
 *         Time: 6:24 PM
 */
public class WordLengthCallable implements Callable {

    private String word;

    public WordLengthCallable(String word) {
        this.word = word;
    }


    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Object call() throws Exception {
        return Integer.valueOf(word.length());
    }
}