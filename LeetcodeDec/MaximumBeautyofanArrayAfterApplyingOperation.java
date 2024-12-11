package LeetcodeDec;

import java.util.*;

public class MaximumBeautyofanArrayAfterApplyingOperation {
    public static void main(String[] args) {
        int nums[] = { 4, 6, 1, 2 }, k = 2;
        System.out.println(maximumBeauty(nums, k));
    }

    public static int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            while (nums[r] - nums[l] > 2 * k) {
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
