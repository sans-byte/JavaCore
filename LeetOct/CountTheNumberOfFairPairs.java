package LeetOct;
// 2563. Count the Number of Fair Pairs

import java.util.*;

public class CountTheNumberOfFairPairs {
    public static void main(String[] args) {
        int nums[] = { 0, 1, 7, 4, 4, 5 };
        int lower = 3;
        int upper = 6;
        System.out.println(countFairPairs(nums, lower, upper));
    }

    // The intution here is to find all the pairs which sums to more than lower
    // Then find all the pairs which sums to more than upper
    // And substract both
    // We can find the pairs with 2 pointers approach

    public static long findPairsMoreThanSum(int[] nums, int sum) {
        int res = 0, i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] > sum)
                j--;
            else {
                res += j - i;
                i++;
            }
        }
        return res;
    }

    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return findPairsMoreThanSum(nums, upper) - findPairsMoreThanSum(nums, lower - 1);
    }
}
