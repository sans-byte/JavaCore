package AABBQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int xAxis[] = { 1, -1, 0, 0 };
        int yAxis[] = { 0, 0, 1, -1 };
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int visited[][] = new int[n][m];
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    if (visited[i][j] == 0) {
                        res++;
                        q.add(new int[] { i, j });
                        while (!q.isEmpty()) {
                            int len = q.size();
                            for (int x = 0; x < len; x++) {
                                int temp[] = q.poll();
                                for (int k = 0; k < 4; k++) {
                                    int row = temp[0] + xAxis[k];
                                    int col = temp[1] + yAxis[k];
                                    if (row >= 0 && row < n && col >= 0 && col < m && visited[row][col] == 0) {
                                        q.add(new int[] { row, col });
                                        visited[row][col] = 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return res;
    }
}
