package ArraysQuestions;

// https://leetcode.com/problems/maximum-subarray/

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};

        System.out.println(maxSubArray(nums));
    }

    static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int i = 0;
        while (i < nums.length) {
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            if (sum > maxSum)
                maxSum = sum;
            i++;
        }
        return maxSum;
    }
}
