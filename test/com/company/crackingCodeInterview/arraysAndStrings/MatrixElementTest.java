package com.company.crackingCodeInterview.arraysAndStrings;

import org.junit.Test;

/**
 * @author dkorolev
 *         Date: 4/19/2019
 *         Time: 6:32 PM
 */
public class MatrixElementTest {

    @Test
    public void checkMatrix() {
        int[][] matrix = {{1, 0, 1}, {1, 0, 1}, {1, 1, 1}};

        MatrixElement.setZerosToRowAndColumn(matrix);

    }


}