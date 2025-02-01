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

    static public boolean helper(char[][] mat, int row, int col, String word, int idx, int[][] visited) {
        if (idx >= word.length())
            return true;
        if (row < 0 || row >= mat.length || col < 0 || col >= mat[0].length || visited[row][col] == 1
                || mat[row][col] != word.charAt(idx)) {
            return false;
        }

        visited[row][col] = 1;

        for (int i = 0; i < 4; i++) {
            int newRow = row + yAxis[i];
            int newCol = col + xAxis[i];

            if (helper(mat, newRow, newCol, word, idx + 1, visited)) {
                return true;
            }
        }

        visited[row][col] = 0;
        return false;
    }

    public static boolean isWordExist(char[][] mat, String word) {
        int visited[][] = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    if (helper(mat, i, j, word, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
