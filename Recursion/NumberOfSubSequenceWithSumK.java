package Recursion;

import java.util.Arrays;

public class NumberOfSubSequenceWithSumK {
    public static void main(String[] args) {
        int[] nums = { 2, 5, 1, 4, 3 };
        int target = 10;

        System.out.println(numberOfSubSeq(nums, target, 0, 0, 0)); // recursion

        int[][] dp = new int[nums.length + 1][target + 1];
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }

        System.out.println(numberOfSubSeqDP(nums, target, 0, 0, 0, dp)); // dp

    }

    static int numberOfSubSeq(int[] nums, int target, int i, int count, int sum) {
        if (sum > target)
            return 0;
        if (i >= nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        count = numberOfSubSeq(nums, target, i + 1, count, sum + nums[i])
                + numberOfSubSeq(nums, target, i + 1, count, sum);
        return count;
    }

    // time complexity 2^n - exponential

    // To make this time complexity linear we need to use dp

    static int numberOfSubSeqDP(int[] nums, int target, int i, int count, int sum, int[][] dp) {
        if (sum > target) {
            return 0;
        }
        if (i >= nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        if (dp[i][sum] != -1)
            return dp[i][sum];

        count = (numberOfSubSeqDP(nums, target, i + 1, count, sum + nums[i], dp)
                + numberOfSubSeqDP(nums, target, i + 1, count, sum, dp)) % (100000000);
        dp[i][sum] = count % (1000000007);
        return count;
    }

}
