package GFG160;

//TODO: Complete it

import java.util.*;

class MaxCircularSubArraySum {
    public static void main(String[] args) {
        // int arr[] = { 10, -3, -4, 7, 6, 5, -4, -1 };
        // int arr[] = { 8, -8, 9, -9, 10, -11, 12 };
        int arr[] = { -311, 320 };
        System.out.println(circularSubarraySum(arr));
    }

    // This approach gives TLE
    public static int circularSubarraySum(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                int sum = arr[i];
                int x = ++i;
                x = x % arr.length;
                for (int p = 1; p < arr.length; p++) {
                    maxSum = Math.max(sum, maxSum);
                    sum += arr[x];
                    x++;
                    x = x % arr.length;
                }
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    public static int circularSubarraySumBetter(int arr[]) {
        
        return 0;
    }

    public static int circularSubarraySumBest(int arr[]) {

        return 0;
    }
}