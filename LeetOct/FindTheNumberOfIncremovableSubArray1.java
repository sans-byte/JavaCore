package LeetOct;

public class FindTheNumberOfIncremovableSubArray1 {
    public static void main(String[] args) {
        // int nums[] = { 6, 5, 7, 8 };
        int nums[] = { 8, 7, 6, 6 };
        System.out.println(incremovableSubarrayCount(nums));
    }

    public static int incremovableSubarrayCount(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (helper(i, j, nums)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean helper(int start, int end, int[] nums) {
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= start && i <= end) {
                continue;
            }
            if (nums[i] < pre) {
                return false;
            }
            pre = nums[i];
        }
        return true;
    }
}
