package LeetOct;

import java.util.*;

import DP.countNumberOfSquares;

// 3011. Find if Array Can Be Sorted

public class FindIfArrayCanBeSorted {
    public static void main(String[] args) {
        int nums[] = { 8, 4, 2, 30, 15 };
        System.out.println(canSortArray(nums));
    }

    public static boolean canSortArray(int[] nums) {
        // with bubble sort
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = 0; j < nums.length - 1; j++) {
        //         if (Integer.bitCount(nums[j]) == Integer.bitCount(nums[j + 1])) {
        //             if (nums[j] > nums[j + 1]) {
        //                 int temp = nums[j];
        //                 nums[j] = nums[j + 1];
        //                 nums[j + 1] = temp;
        //             } else {
        //                 continue;
        //             }
        //         } else {
        //             if (nums[j] > nums[j + 1]) {
        //                 return false;
        //             }
        //         }
        //     }
        // }
        // return true;
        //

        // With login 
        
    }
}
