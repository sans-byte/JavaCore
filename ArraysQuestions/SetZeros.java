package ArraysQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.util.Pair;

// https://leetcode.com/problems/set-matrix-zeroes/

public class SetZeros {
    public static void main(String[] args) {

        int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };

        setZero(matrix);

        for (int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }
    }

    static void setZero(int[][] arr) {
        List<Pair<Integer, Integer>> l = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    Pair<Integer, Integer> p = new Pair<>(i, j);
                    l.add(p);
                }
            }
        }

        for (int i = 0; i < l.size(); i++) {
            Pair p = l.get(i);
            int key = (int) p.getKey();
            int value = (int) p.getValue();

            for (int x = 0; x < arr.length; x++) {
                arr[x][value] = 0;
            }
            for (int y = 0; y < arr[0].length; y++) {
                arr[key][y] = 0;
            }
        }
    }
}
