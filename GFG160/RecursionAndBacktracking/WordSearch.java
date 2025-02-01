package GFG160.RecursionAndBacktracking;

import java.util.*;

public class WordSearch {
    public static int[] yAxis = new int[] { 1, -1, 0, 0 };
    public static int[] xAxis = new int[] { 0, 0, 1, -1 };

    public static void main(String[] args) {
        char mat[][] = { { 'T', 'E', 'E' }, { 'S', 'G', 'K' }, { 'T', 'E', 'L' } };
        String word = "GEEK";
        System.out.println(isWordExist(mat, word));
    }

    static public boolean helper(char[][] mat, int row, int col, String word, int[][] visited) {
        if (word.length() == 1)
            return true;
        char wordArr[] = word.toCharArray();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { row, col, 1 });
        visited[row][col] = 1;
        while (!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                int val[] = q.poll();
                if (val[2] >= wordArr.length)
                    return true;
                for (int k = 0; k < 4; k++) {
                    int newRow = val[0] + yAxis[k];
                    int newCol = val[1] + xAxis[k];

                    if (newRow >= 0 && newRow < mat.length && newCol >= 0 && newCol < mat[0].length
                            && mat[newRow][newCol] == wordArr[val[2]] && visited[newRow][newCol] == 0) {
                        q.add(new int[] { newRow, newCol, val[2] + 1 });
                        visited[newRow][newCol] = 1;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isWordExist(char[][] mat, String word) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    int visited[][] = new int[mat.length][mat[0].length];
                    if (helper(mat, i, j, word, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
