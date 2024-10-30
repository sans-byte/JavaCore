package DP;

import java.util.*;

public class MinimumNumberOfRemovalsToMakeMountainArray {
    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 1, 1, 2, 3, 1 };
        System.out.println(minimumMountainRemovals(nums));
    }

    public static int longestIncreasingSubsequence(int[] nums, int[][] dp, int pre, int i) {
        if (i == nums.length) {
            return 0;
        }

        if (dp[i][pre + 1] != -1) {
            return dp[i][pre + 1];
        }

        int maxCount = longestIncreasingSubsequence(nums, dp, pre, i + 1);

        if (pre == -1 || nums[i] > nums[pre]) {
            maxCount = Math.max(maxCount, 1 + longestIncreasingSubsequence(nums, dp, i, i + 1));
        }

        dp[i][pre + 1] = maxCount;
        return maxCount;
    }

    public static int minimumMountainRemovals(int[] nums) {
        int[][] dp = new int[nums.length][nums.length + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        int maxCountStart = longestIncreasingSubsequence(nums, dp, -1, 0);
        return 0;
    }
}
