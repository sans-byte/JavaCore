package LeetcodeJan;

import java.util.*;

public class CountTheServersThatCommunicate {
    static int yAxis[] = { 1, -1, 0, 0 };
    static int xAxis[] = { 0, 0, 1, -1 };

    public static void main(String[] args) {
        int grid[][] = { { 1, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } };
        System.out.println(countServers(grid));
    }

    public static int countServers(int[][] grid) {
        int res = 0;
        int visited[][] = new int[grid.length][grid[0].length];
        int counted[][] = new int[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            int temp[] = null;
            int count = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (temp == null) {
                        temp = new int[] { i, j };
                        visited[i][j] = 1;
                    }
                    count++;
                }
            }
            if (count > 1) {
                q.add(temp);
            }
        }

        for (int j = 0; j < grid[0].length; j++) {
            int temp[] = null;
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1) {
                    if (temp == null) {
                        temp = new int[] { i, j };
                        visited[i][j] = 1;
                    }
                    count++;
                }
            }
            if (count > 1) {
                q.add(temp);
            }
        }

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int val[] = q.poll();
                int count = 0;
                if (counted[val[0]][val[1]] == 0) {
                    count = 1;
                    counted[val[0]][val[1]] = 1;
                }
                for (int k = 0; k < 4; k++) {
                    int row = yAxis[k] + val[0];
                    int col = xAxis[k] + val[1];

                    if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
                        if (grid[row][col] == 1) {
                            if (counted[row][col] == 0) {
                                count++;
                                counted[row][col] = 1;
                            }

                            if (visited[row][col] == 0) {
                                q.add(new int[] { row, col });
                                visited[row][col] = 1;
                            }
                        }

                    }
                }
                res += count;
            }
        }

        for (int[] row : counted)
            System.out.println(Arrays.toString(row));

        return res;
    }
}
