package LeetcodeJan;

import java.util.*;

public class MakingALargeIsland {
    static int yAxis[] = new int[] { 1, -1, 0, 0 };
    static int xAxis[] = new int[] { 0, 0, -1, 1 };

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 0, 1, 0 },
                { 0, 0, 0, 1 },
                { 1, 0, 1, 0 },
                { 1, 0, 1, 0 }
        };
        System.out.println(largestIsland(grid));
        for (int i[] : grid) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static void compute(int[][] grid, int row, int col, int code, Map<Integer, Integer> map) {
        Queue<int[]> q = new LinkedList<>();
        grid[row][col] = code;
        int area = 1;
        q.add(new int[] { row, col });
        while (!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                int index[] = q.poll();
                for (int k = 0; k < 4; k++) {
                    int newRow = index[0] + yAxis[k];
                    int newCol = index[1] + xAxis[k];

                    if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid.length
                            && grid[newRow][newCol] == 1) {
                        area++;
                        grid[newRow][newCol] = code;
                        q.add(new int[] { newRow, newCol });
                    }
                }
            }
        }
        map.put(code, area);
    }

    public static void preComputationAreaOfIlands(int[][] grid, Map<Integer, Integer> map) {
        int n = grid.length;
        int code = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    compute(grid, i, j, code++, map);
                }
            }
        }
    }

    public static int flipAndGetArea(int[][] grid, int row, int col, Map<Integer, Integer> map) {
        int area = 1;
        Set<Integer> s = new HashSet<>();
        for (int k = 0; k < 4; k++) {
            int newRow = row + yAxis[k];
            int newCol = col + xAxis[k];

            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid.length
                    && !s.contains(grid[newRow][newCol])) {
                int code = grid[newRow][newCol];
                area += map.get(code);
                s.add(code);
            }
        }
        return area;
    }

    public static int largestIsland(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        preComputationAreaOfIlands(grid, map);
        System.out.println(map);
        int res = 0;
        for (int i : map.values()) {
            res = Math.max(i, res);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res = Math.max(res, flipAndGetArea(grid, i, j, map));
                }
            }
        }
        return res;
    }
}
