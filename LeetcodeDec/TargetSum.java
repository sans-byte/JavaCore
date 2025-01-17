
public class TargetSum {
    public static void main(String[] args) {
        int nums[] = { 1, 1, 1, 1, 1 }, target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }

    // Recursion (2 ^ N)
    public static int helper(int nums[], int index, int sum, int target) {
        if (index >= nums.length) {
            if (target == sum) {
                return 1;
            }
            return 0;
        }
        int add = helper(nums, index + 1, sum + nums[index], target);
        int subs = helper(nums, index + 1, sum - nums[index], target);
        return add + subs;
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int dp[] = new int[nums.length];
        return helper(nums, 0, 0, target);
    }

    // could also be done with DP in efficient manner
}
