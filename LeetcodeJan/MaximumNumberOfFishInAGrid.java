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
    public static int helper(int[][] grid, int i, int j, int[][] visited) {
        if (grid[i][j] == 0 || visited[i][j] == 1) {
            return 0;
        }
        visited[i][j] = 1;
        int fishes = grid[i][j];
        for (int k = 0; k < 4; k++) {
            int row = i + yAxis[k];
            int col = j + xAxis[k];
            if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
                fishes += helper(grid, row, col, visited);
            }
        }
        return fishes;
    }

    public static int findMaxFish(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    int visited[][] = new int[grid.length][grid[0].length];
                    res = Math.max(res, helper(grid, i, j, visited));
                }
            }
        }
        return res;
    }
}
