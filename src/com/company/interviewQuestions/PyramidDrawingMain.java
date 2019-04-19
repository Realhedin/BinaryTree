package com.company.interviewQuestions;

/**
 * @author dkorolev
 *         Date: 3/13/2019
 *         Time: 8:59 PM
 */
public class PyramidDrawingMain {

    public static void main(String[] args) {
        pyramidDrawing(5);
    }



    public static void pyramidDrawing(int number) {

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

}
