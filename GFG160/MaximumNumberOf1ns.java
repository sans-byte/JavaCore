package GFG160;

import java.util.Arrays;

public class MaximumNumberOf1ns {
    public static void main(String[] args) {
        int arr[] = { 1, 0, 0, 1, 0, 1, 0, 1 }, k = 2;
        System.out.println(maxOnes(arr, k));

    }

    public static int maxOnes(int arr[], int k) {
        int i = 0, j = 0, count = 0, max = Integer.MIN_VALUE;

        while (i < arr.length && j < arr.length) {
            if (arr[j] == 0) {
                count++;
            }

            while (count > k) {
                if (arr[i] == 0) {
                    count--;
                }
                i++;
            }

            max = Math.max(max, j - i + 1);
            j++;

        }
        return max;
    }
}
