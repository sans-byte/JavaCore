package GFG160;

import java.util.*;

public class MoveAllZerosAtTheEnd {
    public static void main(String[] args) {
        // int arr[] = { 3, 4, 0, 0, 4 };
        int arr[] = { 1, 2, 0, 4, 3, 0, 5, 0 };
        pushZerosToEnd(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void pushZerosToEnd(int[] arr) {
        int lastNonZeroIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[lastNonZeroIndex] = arr[i];
                lastNonZeroIndex++;
            }
        }
        for (int i = lastNonZeroIndex; i < arr.length; i++) {
            arr[i] = 0;
        }
    }
}
