package LeetOct;

import java.util.*;

public class CountUngardedCellsInAGrid {
    public static void main(String[] args) {
        // int m = 4, n = 6, guards[][] = { { 0, 0 }, { 1, 1 }, { 2, 3 } }, walls[][] =
        // { { 0, 1 }, { 2, 2 }, { 1, 4 } };
        int m = 6, n = 10,
                guards[][] = { { 0, 6 }, { 2, 2 }, { 2, 5 }, { 1, 2 }, { 4, 9 }, { 2, 9 }, { 5, 6 }, { 4, 6 } },
                walls[][] = { { 1, 5 } };
        System.out.println(countUnguarded(m, n, guards, walls));
    }

    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        // Mark guards and walls on the grid
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2;
        }

        // Mark cells visible to guards
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) { // Guard's position
                    // South
                    for (int x = i + 1; x < m; x++) {
                        if (grid[x][j] == 2 || grid[x][j] == 1)
                            break;
                        if (grid[x][j] == 0)
                            grid[x][j] = 3;
                    }
                    // North
                    for (int x = i - 1; x >= 0; x--) {
                        if (grid[x][j] == 2 || grid[x][j] == 1)
                            break;
                        if (grid[x][j] == 0)
                            grid[x][j] = 3;
                    }
                    // East
                    for (int y = j + 1; y < n; y++) {
                        if (grid[i][y] == 2 || grid[i][y] == 1)
                            break;
                        if (grid[i][y] == 0)
                            grid[i][y] = 3;
                    }
                    // West
                    for (int y = j - 1; y >= 0; y--) {
                        if (grid[i][y] == 2 || grid[i][y] == 1)
                            break;
                        if (grid[i][y] == 0)
                            grid[i][y] = 3;
                    }
                }
            }
        }

        for (int[] i : grid) {
            System.out.println(Arrays.toString(i));
        }

        // Count unguarded cells
        int res = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 0) {
                    res++;
                }
            }
        }

        return res;
    }

}
