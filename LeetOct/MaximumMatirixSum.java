package LeetOct;

import java.util.*;

public class MaximumMatirixSum {
    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3 }, { -1, -2, -3 }, { 1, 2, 3 } };
        System.out.println(maxMatrixSum(matrix));
    }

    public static long maxMatrixSum(int[][] matrix) {
        int negCount = 0, min = Integer.MAX_VALUE, sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 0) {
                    negCount++;
                }
                int val = Math.abs(matrix[i][j]);
                min = Math.min(val, min);
                sum += val;
            }
        }
        if (negCount % 2 == 0)
            return sum;
        return sum - 2 * min;
    }
}