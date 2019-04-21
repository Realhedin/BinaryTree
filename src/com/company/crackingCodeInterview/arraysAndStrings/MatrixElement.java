package com.company.crackingCodeInterview.arraysAndStrings;

/**
 * @author dkorolev
 * Date: 4/19/2019
 * Time: 5:55 PM
 */
public class MatrixElement {


    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1}, {1, 0, 1}, {1, 1, 1}};
        showMatrix(matrix);
        System.out.println();
        int[][] ints = setZerosToRowAndColumn(matrix);
        showMatrix(ints);
    }



    //O(n^2) + O(n^2) => O(n^2) complexity
    public static int[][] setZerosToRowAndColumn(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] column = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    column[j] = 1;
                    break;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (row[i] == 1 || column[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }


    private static void showMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}