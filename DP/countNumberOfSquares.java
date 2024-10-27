package DP;

import java.util.Arrays;

// 1277. Count Square Submatrices with All Ones

public class countNumberOfSquares {
    public static void main(String[] args) {
        int matrix[][] = {
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 1, 1, 1 }
        };
        System.out.println(countSquares(matrix));
    }

    public static int countSquares(int[][] matrix) {
        int sum = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0];
            sum += dp[i][0];
        }

        for (int i = 1; i < n; i++) {
            dp[0][i] = matrix[0][i];
            sum += dp[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
                sum += dp[i][j];
            }
            System.out.println(Arrays.toString(dp[i]));
        }
        return sum;
    }
}
