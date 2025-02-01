import java.util.*;

public class WordSearch {
    public static int[] yAxis = new int[] { 1, -1, 0, 0 };
    public static int[] xAxis = new int[] { 0, 0, 1, -1 };

    public static void main(String[] args) {
        char mat[][] = { { 'T', 'E', 'E' }, { 'S', 'G', 'K' }, { 'T', 'E', 'L' } };
        String word = "GEEK";
        System.out.println(isWordExist(mat, word));
    }

    static public boolean helper(char[][] mat, int row, int col, String word) {
        char wordArr[] = word.toCharArray();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { row, col });
        int idx = 1;
        while (!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                int val[] = q.poll();
                for (int k = 0; k < 4; k++) {
                    int newRow = val[0] + yAxis[k];
                    int newCol = val[1] + xAxis[k];

                    if (newRow >= 0 && newRow < mat.length && newCol >= 0 && newCol < mat[0].length
                            && mat[newRow][newCol] == wordArr[idx]) {
                        q.add(new int[] { newRow, newCol });
                        idx++;
                        if (idx >= word.length())
                            return true;
                    }
                }
            }
        }
        return false;
    }

    static public boolean isWordExist(char[][] mat, String word) {

    }

}
