package DP;

import java.util.Arrays;

// 2684. Maximum Number of Moves in a Grid

public class MaximumNumberOfMovesInGrid {
    public static void main(String[] args) {
        int grid[][] = { { 65, 200, 263, 220, 91, 183, 2, 187, 175, 61, 225, 120, 39 },
                { 111, 242, 294, 31, 241, 90, 145, 25, 262, 214, 145, 71, 294 },
                { 152, 25, 240, 69, 279, 238, 222, 9, 137, 277, 8, 143, 143 },
                { 189, 31, 86, 250, 20, 63, 188, 209, 75, 22, 127, 272, 110 },
                { 122, 94, 298, 25, 90, 169, 68, 3, 208, 274, 202, 135, 275 },
                { 205, 20, 171, 90, 70, 272, 280, 138, 142, 151, 80, 122, 130 },
                { 284, 272, 271, 269, 265, 134, 185, 243, 247, 50, 283, 20, 232 },
                { 266, 236, 265, 234, 249, 62, 98, 130, 122, 226, 285, 168, 204 },
                { 231, 24, 256, 101, 142, 28, 268, 82, 111, 63, 115, 13, 144 },
                { 277, 277, 31, 144, 49, 132, 28, 138, 133, 29, 286, 45, 93 },
                { 163, 96, 25, 9, 3, 159, 148, 59, 25, 81, 233, 127, 12 },
                { 127, 38, 31, 209, 300, 256, 15, 43, 74, 64, 73, 141, 200 } };
        System.out.println(maxMoves(grid));
    }

    public static int countMoves(int row, int col, int[][] grid, int[][] dp) {
        if (dp[row][col] != -1)
            return dp[row][col];

        int maxMoves = 0;

        if (col + 1 < grid[0].length && grid[row][col + 1] > grid[row][col]) {
            maxMoves = Math.max(maxMoves, 1 + countMoves(row, col + 1, grid, dp));
        }

        if (row + 1 < grid.length && col + 1 < grid[0].length && grid[row + 1][col + 1] > grid[row][col]) {
            maxMoves = Math.max(maxMoves, 1 + countMoves(row + 1, col + 1, grid, dp));
        }

        if (col + 1 < grid[0].length && row - 1 >= 0 && grid[row - 1][col + 1] > grid[row][col]) {
            maxMoves = Math.max(maxMoves, 1 + countMoves(row - 1, col + 1, grid, dp));
        }

        dp[row][col] = maxMoves;

        return maxMoves;
    }

    public static int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxMoves = 0;
        int dp[][] = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        for (int i = 0; i < m; i++) {
            maxMoves = Math.max(maxMoves, countMoves(i, 0, grid, dp));
        }
        return maxMoves;
    }
}
