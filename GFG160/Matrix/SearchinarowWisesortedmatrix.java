package GFG160.Matrix;

import java.util.*;

public class SearchinarowWisesortedmatrix {

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 3, 5 },
                { 10, 11, 16 },
                { 20, 23, 30 }
        };
        int x = 13;
        System.out.println(searchRowMatrix(mat, x));
    }

    public static boolean binarySearch(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return false;
    }

    public static boolean searchRowMatrix(int[][] mat, int x) {
        for (int i = 0; i < mat.length; i++) {
            if (x >= mat[i][0] && x <= mat[i][mat[i].length - 1]) {
                if (binarySearch(mat[i], x))
                    return true;
            }
        }
        return false;
    }
}
