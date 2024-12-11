package GFG160.Sorting;

import java.util.*;

public class OverLappingIntervals {
    public static void main(String[] args) {
        // int arr[][] = { { 6, 8 }, { 1, 9 }, { 2, 4 }, { 4, 7 } };
        int arr[][] = { { 1, 3 }, { 2, 4 }, { 6, 8 }, { 9, 10 } };
        System.out.println(mergeOverlap(arr));
    }

    public static List<int[]> mergeOverlap(int[][] arr) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(arr, (x, y) -> x[0] - y[0]);
        int x = arr[0][0];
        int y = arr[0][1];
        for (int[] i : arr) {
            if (i[0] <= y) {
                if (y < i[1]) {
                    y = i[1];
                }
            } else {
                res.add(new int[] { x, y });
                x = i[0];
                y = i[1];
            }
        }
        res.add(new int[] { x, y });
        return res;
    }
}