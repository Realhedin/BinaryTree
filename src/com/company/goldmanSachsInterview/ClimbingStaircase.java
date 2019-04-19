package com.company.goldmanSachsInterview;

/**
 * @author dkorolev
 *         Date: 4/16/2019
 *         Time: 1:30 PM
 */
public class ClimbingStaircase {

    // O(2^n) - because it's recursive tree
    public static int climbBruteForce(int n) {
        return climb_Stairs(0, n);
    }

    public static int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }


    // O(n) - because of memorization
    public static int climbBruteForceMemo(int n) {
        int memo[] = new int[n + 1];
        return climb_StairsMemo(0, n, memo);
    }

    public static int climb_StairsMemo(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_StairsMemo(i + 1, n, memo) + climb_StairsMemo(i + 2, n, memo);
        return memo[i];
    }


    //dynamic programming O(n)
    public static int dynamicClimbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }


    //dynamic fibonacchi numbers O(n)
    public static int fibbonachiNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        int fibNumber = 0;
        for (int i = 3; i <= n; i++) {
            fibNumber = first + second;
            first = second;
            second = fibNumber;
        }
        return fibNumber;
    }
}