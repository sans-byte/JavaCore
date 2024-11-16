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
        int zeroCount = 0;
        for (int i : arr) {
            if (i == 0)
                zeroCount++;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                zeroCount--;
                if (zeroCount == 0)
                    return;
                continue;
            } else {
                int j = i;
                while (j >= 0 && arr[j] != 0) {
                    j--;
                }
                while (j >= 0 && j < arr.length - 1 && j <= i) {
                    arr[j] = arr[j + 1];
                    arr[j + 1] = 0;
                    j++;
                }
            }

        }
    }
}
