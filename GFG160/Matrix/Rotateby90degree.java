package GFG160.Matrix;

import java.util.Arrays;

public class Rotateby90degree {
    public static void main(String[] args) {
        // int mat[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // int mat[][] = { { 1, 2 }, { 3, 4 } };
        int mat[][] = { {} };
        rotateby90(mat);
        for (int[] i : mat) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static void rotateby90(int mat[][]) {
        int n = mat.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[n - 1 - j][n - 1 - i];
                mat[n - 1 - j][n - 1 - i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = mat[i][n - 1 - j];
                mat[i][n - 1 - j] = mat[i][j];
                mat[i][j] = temp;
            }
        }
    }
}
