package AABBQuestions;

// same is LIS DP approach check it out (Longest increasing subsequence)

import java.util.ArrayList;

public class FindTheMaximumLengthOfagoodsubsequence1 {
    public static int res;

    public static void main(String[] args) {
        // int nums[] = { 1, 2, 1, 1, 3 }, k = 2;
        int nums[] = { 1, 2, 3, 4, 5, 1 }, k = 0;
        System.out.println(maximumLength(nums, k));
    }

    public static int helper(int[] arr, int index, int k, int prev) {
        // base
        if (index == arr.length)
            return 0;

        int pick = 0;

        if (prev == -1 || arr[index] == arr[prev]) {
            pick = 1 + helper(arr, index + 1, k, index);
        } else if (k > 0) {
            pick = 1 + helper(arr, index + 1, k - 1, index);
        }

        int notPick = helper(arr, index + 1, k, prev);

        return Math.max(pick, notPick);
    }

    public static int maximumLength(int[] nums, int k) {
        return helper(nums, 0, k, -1);
    }
}
