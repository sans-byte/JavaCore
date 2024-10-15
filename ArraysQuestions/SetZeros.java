package ArraysQuestions;
import java.util.Arrays;

// https://leetcode.com/problems/set-matrix-zeroes/

public class SetZeros {
    public static void main(String[] args) {

        // int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        int[][] matrix = { { 1 }, { 0 } };

        setZero(matrix);

        for (int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }
    }

    static void setZero(int[][] arr) {
        // List<Pair<Integer, Integer>> l = new ArrayList<>();

        // for (int i = 0; i < arr.length; i++) {
        // for (int j = 0; j < arr[i].length; j++) {
        // if (arr[i][j] == 0) {
        // Pair<Integer, Integer> p = new Pair<>(i, j);
        // l.add(p);
        // }
        // }
        // }

        // for (int i = 0; i < l.size(); i++) {
        // Pair p = l.get(i);
        // int key = (int) p.getKey();
        // int value = (int) p.getValue();

        // for (int x = 0; x < arr.length; x++) {
        // arr[x][value] = 0;
        // }
        // for (int y = 0; y < arr[0].length; y++) {
        // arr[key][y] = 0;
        // }
        // }

        int n = arr.length;
        int m = arr[0].length;

        int col1 = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;

                    if (j != 0) {
                        arr[0][j] = 0;
                    } else {
                        col1 = 0;
                    }
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][j] != 0) {
                    if (arr[i][0] == 0 || arr[0][j] == 0) {
                        arr[i][j] = 0;
                    }
                }
            }
        }

        if (arr[0][0] == 0) {
            for (int j = 1; j < m; j++) {
                arr[0][j] = 0;
            }
        }

        if (col1 == 0) {
            for (int i = 0; i < n; i++) {
                arr[i][0] = 0;
            }
        }
    }
}
