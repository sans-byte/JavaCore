package AABBQuestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    static int yAxis[] = { 1, -1, 0, 0 };
    static int xAxis[] = { 0, 0, 1, -1 };

    public static void main(String[] args) {
        int mat[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        int res[][] = updateMatrix(mat);
        for (int i[] : res)
            System.out.println(Arrays.toString(i));
    }

    public static int[][] updateMatrix(int[][] mat) {
        int res[][] = new int[mat.length][mat[0].length];
        int visited[][] = new int[mat.length][mat[0].length];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1)
                    res[i][j] = 1;
            }
        }
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                if (res[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int row = i + yAxis[k];
                        int col = j + xAxis[k];
                        if (row >= 0 && row < res.length && col >= 0 && col < res[0].length && visited[row][col] == 0
                                && res[row][col] == 1) {
                            q.add(new int[] { row, col });
                            visited[row][col] = 1;
                        }
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int val[] = q.poll();
                for (int k = 0; k < 4; k++) {
                    int row = val[0] + yAxis[k];
                    int col = val[1] + xAxis[k];
                    if (row >= 0 && row < res.length && col >= 0 && col < res[0].length && res[row][col] == 1
                            && visited[row][col] == 0) {
                        q.add(new int[] { row, col });
                        visited[row][col] = 1;
                        res[row][col] = res[val[0]][val[1]] + 1;
                    }
                }
            }
        }
        return res;
    }
}
