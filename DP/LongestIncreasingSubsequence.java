package DP;

import java.util.*;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int nums[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(lengthOfLIS(nums));
    }

    // public static void powerSetWithCondition(int[] nums, int pre, int i, int
    // count, int[] maxCount) {
    // if (i == nums.length) {
    // maxCount[0] = Math.max(maxCount[0], count);
    // return;
    // }

    // if (pre == -1 || (nums[i] > nums[pre])) {
    // powerSetWithCondition(nums, i, i + 1, count + 1, maxCount);
    // }
    // powerSetWithCondition(nums, pre, i + 1, count, maxCount);
    // }

    public static int powerSetWithConditionDP(int[] nums, int pre, int i, int[][] dp) {
        if (i == nums.length) {
            return 0;
        }

        if (dp[i][pre + 1] != -1) {
            return dp[i][pre + 1];
        }

        int maxLen = powerSetWithConditionDP(nums, pre, i + 1, dp);

        if (pre == -1 || (nums[i] > nums[pre])) {
            maxLen = Math.max(maxLen, 1 + powerSetWithConditionDP(nums, i, i + 1, dp));
        }

        dp[i][pre + 1] = maxLen;
        return maxLen;
    }

    public static int lengthOfLIS(int[] nums) {
        // int maxCount[] = new int[1];
        // powerSetWithCondition(nums, -1, 0, 0, maxCount); gives TLE
        // return maxCount[0];

        // We have to do a DP solution
        int dp[][] = new int[nums.length][nums.length + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        int maxCount = powerSetWithConditionDP(nums, -1, 0, dp);
        return maxCount;

    }
}