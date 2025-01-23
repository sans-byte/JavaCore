package AABBQuestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    static int yAxis[] = { 1, -1, 0, 0 };
    static int xAxis[] = { 0, 0, 1, -1 };

    public static void main(String[] args) {
        int grid[][] = { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
        System.out.println(numEnclaves(grid));
    }

    public static int numEnclaves(int[][] grid) {
        int res = 0;
        int n = grid.length;
        int m = grid[0].length;
        int resMatrix[][] = new int[n][m];
        int visited[][] = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resMatrix[i][j] = grid[i][j];
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (resMatrix[i][j] == 1) {
                        q.add(new int[] { i, j });
                        visited[i][j] = 1;
                        resMatrix[i][j] = 0;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] val = q.poll();
                for (int k = 0; k < 4; k++) {
                    int row = val[0] + yAxis[k];
                    int col = val[1] + xAxis[k];

                    if (row >= 0 && row < n && col >= 0 && col < m && resMatrix[row][col] == 1
                            && visited[row][col] == 0) {
                        resMatrix[row][col] = 0;
                        q.add(new int[] { row, col });
                        visited[row][col] = 1;
                    }
                }
            }
        }

        for (int[] i : resMatrix) {
            res += Arrays.stream(i).filter(num -> num == 1).count();
        }

        return res;
    }
}
