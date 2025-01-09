package GFG160.TwoPointers;

import java.util.Arrays;

public class CountTheNumberOfValidTraingles {
    public static void main(String[] args) {
        int nums[] = { 2, 2, 3, 4 };
        System.out.println(triangleNumber(nums));
    }

    public static int triangleNumber(int[] nums) {
        if (nums.length < 3)
            return 0;
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            int j = 0;
            int k = i - 1;
            while (j < k) {
                if (nums[j] + nums[k] > nums[i]) {
                    count += k - j;
                    k--;
                } else {
                    j++;
                }
            }
        }
        return count;
    }

}
