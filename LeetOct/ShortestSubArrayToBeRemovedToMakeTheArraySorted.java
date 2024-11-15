package LeetOct;

// 1574. Shortest Subarray to be Removed to Make Array Sorted

import java.util.*;

public class ShortestSubArrayToBeRemovedToMakeTheArraySorted {
    public static void main(String[] args) {
        // int arr[] = { 1, 2, 3, 10, 4, 2, 3, 5 };
        int arr[] = { 1, 2, 3, 10, 0, 7, 8, 9 };
        System.out.println(findLengthOfShortestSubarray(arr));
    }

    public static int findLengthOfShortestSubarray(int[] arr) {
        int i = 0, j = arr.length - 1, maxCount = 0;
        while (i < arr.length - 1 && arr[i + 1] >= arr[i]) {
            i++;
        }
        if (i == arr.length - 1)
            return 0;

        while (j > 0 && arr[j - 1] <= arr[j]) {
            j--;
        }

        maxCount = Math.max(i + 1, arr.length - j);
        int left = 0;
        int right = j;
        while (left <= i && right < arr.length) {
            if (arr[left] <= arr[right]) {
                maxCount = Math.max(maxCount, arr.length - right + left + 1);
                left++;
            } else {
                right++;
            }
        }
        return arr.length - maxCount;
    }
}
