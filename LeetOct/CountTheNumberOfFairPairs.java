package LeetOct;
// 2563. Count the Number of Fair Pairs

import java.util.*;

public class CountTheNumberOfFairPairs {
    public static void main(String[] args) {
        int nums[] = { -5,-7,-5,-7,-5 };
        int lower = -12;
        int upper = -12;
        System.out.println(countFairPairs(nums, lower, upper));
    }

    public static long countFairPairs(int[] nums, int lower, int upper) {
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] >= lower && nums[i] + nums[j] <= upper) {
                    count++;
                }
            }
        }
        System.out.println(count);
        return 0;
    }
}
