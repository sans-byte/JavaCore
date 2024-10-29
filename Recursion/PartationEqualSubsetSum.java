package Recursion;

import java.util.*;

public class PartationEqualSubsetSum {
    public static void main(String[] args) {
        int nums[] = { 1, 3, 3, 5 };
        System.out.println(canPartition(nums));
    }

    public static boolean getPartation(int[] nums, int halfSum, int sum, int i) {
        if (i >= nums.length) {
            return false;
        }
        if (sum == halfSum) {
            return true;
        }
        return (getPartation(nums, halfSum, sum + nums[i], i + 1) || getPartation(nums, halfSum, sum, i + 1));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int halfSum = sum / 2;
        return getPartation(nums, halfSum, 0, 0);
    }


    //above is giving TLE 

    //DP solution
}
