package LeetcodeJan;

import java.util.*;

public class MaximumNumberOfFishInAGrid {
    public static int yAxis[] = { -1, 1, 0, 0 };
    public static int xAxis[] = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        int grid[][] = { { 0, 2, 1, 0 }, { 4, 0, 0, 3 }, { 1, 0, 0, 4 }, { 0, 3, 2, 0 } };
        System.out.println(findMaxFish(grid));
    }

    // perform dfs and get the values
    public static int helper(int[][] grid, int i, int j) {
        if (grid[i][j] == 0) {
            return 0;
        }
        int fishes = 0;
        for (int k = 0; k < 4; k++) {
            int row = i + yAxis[k];
            int col = j + xAxis[k];
            if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
                fishes = grid[i][j] + helper(grid, row, col);
            }
        }
        return fishes;
    }

    public static int findMaxFish(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int row = i + yAxis[k];
                        int col = j + xAxis[k];
                        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
                            res = Math.max(res, helper(grid, row, col));
                        }
                    }
                }
            }
        }
        return res;
    }
}
