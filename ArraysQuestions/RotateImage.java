package ArraysQuestions;

import java.util.Arrays;

public class RotateImage {

    // https://leetcode.com/problems/rotate-image/
    public static void main(String[] args) {

        // int[][] matrix = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15,
        // 14, 12, 16 } };
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        rotateMatrix(matrix);
        for (int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }

    }

    static void rotateMatrix(int[][] arr) {
        int lastJ = arr.length - 1;
        int lastI = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++) {
            lastI = arr.length - 1;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[lastI][lastJ];
                arr[lastI][lastJ] = temp;
                // System.out.println(arr[lastI][lastJ]);
                lastI--;
            }
            lastJ--;
        }
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int[] temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

}
