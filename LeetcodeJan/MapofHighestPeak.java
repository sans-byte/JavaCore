package LeetcodeJan;

import java.util.*;

public class MapofHighestPeak {
    static int xAxis[] = new int[] { 1, -1, 0, 0 };
    static int yAxis[] = new int[] { 0, 0, 1, -1 };

    public static void main(String[] args) {
        // int isWater[][] = { { 0, 0, 1 }, { 1, 0, 0 }, { 0, 0, 0 } };
        // int isWater[][] = { { 0, 1 }, { 0, 0 } };
        int isWater[][] = { { 0, 1, 1 }, { 1, 0, 0 }, { 1, 0, 1 }, { 0, 0, 0 }, { 0, 1, 0 } };
        System.out.println(highestPeak(isWater));
    }

    public static void helper(int[][] res, int i, int j, Queue<int[]> q) {
        for (int k = 0; k < 4; k++) {
            int row = i + yAxis[k];
            int col = j + xAxis[k];
            if (row >= 0 && row < res.length && col >= 0 && col < res[0].length && res[row][col] == Integer.MAX_VALUE) {
                res[row][col] = res[i][j] + 1;
                q.add(new int[] { row, col });
            }
        }
    }

    public static void helperMakeOnes(int[][] res, int i, int j, Queue<int[]> q) {
        for (int k = 0; k < 4; k++) {
            int row = i + yAxis[k];
            int col = j + xAxis[k];
            if (row >= 0 && row < res.length && col >= 0 && col < res[0].length) {
                if (res[row][col] == Integer.MAX_VALUE) {
                    res[row][col] = 1;
                    q.add(new int[] { row, col });
                }
            }
        }
    }

    public static int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        Queue<int[]> q = new LinkedList<>();
        int res[][] = new int[n][m];
        for (int[] row : res) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    res[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (res[i][j] == 0) {
                    helperMakeOnes(res, i, j, q);
                }
            }
        }

        while (q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] val = q.poll();
                helper(res, val[0], val[1], q);
            }
        }

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // if (res[i][j] == Integer.MAX_VALUE) {
        // res[i][j] = helperMinValue(res, i, j) + 1;
        // }
        // }
        // }
        for (int[] row : res) {
            System.out.println(Arrays.toString(row));
        }
        return res;
    }
}
