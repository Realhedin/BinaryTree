package com.company.crackingCodeInterview.arraysAndStrings;

/**
 * @author dkorolev
 *         Date: 4/19/2019
 *         Time: 5:55 PM
 */
public class MatrixElement {

    //O(n^2)
    public static void setZerosToRowAndColumn(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    setRowAndColumnZeros(matrix, i, j);
                    break;
                }
            }
        }

    }

    private static void setRowAndColumnZeros(int[][] matrix, int row, int col) {
        for (int i = 0; i < matrix[col].length; i++) {
            matrix[i][col] = 0;
        }
        for (int j = 0; j < matrix[row].length; j++) {
            matrix[row][j] = 0;
        }
    }
}