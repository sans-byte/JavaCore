package GFG160.Searching;

import java.util.*;

public class AllocateMinimumPages {
    public static void main(String[] args) {
        // int arr[] = { 12, 34, 67, 90 }, k = 2;
        // int arr[] = { 15, 10, 19, 10, 5, 18, 7 }, k = 5;
        int arr[] = { 13, 31, 37, 45, 46, 54, 55, 63, 73, 84, 85 }, k = 9;
        System.out.println(findPages(arr, k));
    }

    public static int findPages(int[] arr, int k) {
        if (arr.length < k)
            return -1;
        int l = Arrays.stream(arr).max().getAsInt();
        int r = Arrays.stream(arr).sum();
        while (l < r) {
            int mid = l + (r - l) / 2;
            int count = 1;
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                if (sum > mid) {
                    count++;
                    sum = arr[i];
                }
            }
            if (count > k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
