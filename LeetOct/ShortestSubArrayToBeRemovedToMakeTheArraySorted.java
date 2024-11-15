package LeetOct;

// 1574. Shortest Subarray to be Removed to Make Array Sorted

import java.util.*;

public class ShortestSubArrayToBeRemovedToMakeTheArraySorted {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 10, 4, 2, 3, 5 };
        System.out.println(findLengthOfShortestSubarray(arr));
    }

    public static int findLengthOfShortestSubarray(int[] arr) {
        int i = 0, j = arr.length - 1, maxCount = 1;
        while (i < arr.length - 2 && arr[i + 1] >= arr[i]) {
            i++;
        }
        while (j >= 1 && arr[j - 1] <= arr[j]) {
            j--;
        }
        maxCount = Math.max(i + 1, arr.length - j);
        while (i >= 0 && (i == j || arr[i] > arr[j])) {
            i--;
        }

        int val = i + 1 + arr.length - j;
        maxCount = Math.max(maxCount, val);
        return arr.length - maxCount;
    }
}
