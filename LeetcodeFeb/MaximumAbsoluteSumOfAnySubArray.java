package LeetcodeFeb;

public class MaximumAbsoluteSumOfAnySubArray {
    public static void main(String[] args) {
        int nums[] = { 2, -5, 1, -4, 3, -2 };
        System.out.println(maxAbsoluteSum(nums));
    }

    public static int kadaneAlgo(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < 0)
                sum = 0;
            max = Math.max(sum, max);
        }
        return max;
    }

    public static int[] reverSign(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            nums[i] = -nums[i];
        return nums;
    }

    public static int maxAbsoluteSum(int[] nums) {
        // First intutuion apply kadane's algo first noraml and then after reversing the
        // signs
        return Math.max(kadaneAlgo(nums), kadaneAlgo(reverSign(nums)));
    }
}
