package GFG160.Matrix;

import java.util.*;

class SpiralTraversal {
    public static void main(String[] args) {
        int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13,
                14, 15, 16 } };
        // int mat[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15,
        // 16, 17, 18 } };
        // int mat[][] = { { 32, 44, 27, 23 }, { 54, 28, 50, 62 } };
        System.out.println(spirallyTraverse(mat));
    }

    public static ArrayList<Integer> spirallyTraverse(int mat[][]) {
        ArrayList<Integer> res = new ArrayList<>();
        int top = 0;
        int bottom = mat.length - 1;
        int left = 0;
        int right = mat[0].length - 1;

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++) {
                res.add(mat[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                res.add(mat[i][right]);
            }

            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(mat[bottom][i]);
                }
                bottom--;
            }

            for (int i = bottom; i >= top; i--) {
                res.add(mat[i][left]);
            }
            left++;
        }

        return res;
    }
}