package BinarySearch;

import java.util.Arrays;

// https://leetcode.com/problems/longest-subsequence-with-limited-sum/

public class LongestSubSequenceWithLimitedSum {
    public static void main(String[] args) {
        int nums[] = { 4, 5, 2, 1 };
        int queries[] = { 3, 10, 21 };
        System.out.println(Arrays.toString(ansQue(nums, queries)));
        System.out.println(Arrays.toString(ansQueBinary(nums, queries)));
    }

    public static int[] answerQueries(int[] nums, int[] queries) { // this approach gave TLE coz obviosly it goes to 2^n
                                                                   // * n
        int res[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = 0;
            int r = nums.length;
            boolean flag[] = new boolean[1];
            int length = 0;
            while (l <= r) {
                length = 0;
                flag[0] = false;
                int mid = l + (r - l) / 2;
                System.out.println(mid);
                getPowerSet(nums, 0, mid, 0, queries[i], flag, length);
                if (flag[0] == true) {
                    if (mid > res[i])
                        res[i] = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return res;
    }

    static public void getPowerSet(int[] nums, int i, int max, int sum, int maxSum, boolean[] flag, int length) {
        if (i == nums.length) {
            if (sum <= maxSum && length == max) {
                flag[0] = true;
            }
            return;
        }
        getPowerSet(nums, i + 1, max, sum, maxSum, flag, length);
        getPowerSet(nums, i + 1, max, sum + nums[i], maxSum, flag, length + 1);
    }

    public static int[] ansQue(int[] nums, int[] queries) {
        int[] res = new int[queries.length];
        Arrays.sort(nums);
        for (int i = 0; i < queries.length; i++) {
            int sum = 0;
            for (int x = 0; x < nums.length; x++) {
                sum += nums[x];
                if (sum <= queries[i]) {
                    res[i] = Math.max(res[i], x + 1);
                }
            }
        }
        return res;
    }

    public static int[] ansQueBinary(int[] nums, int[] queries) {
        int[] res = new int[queries.length];
        Arrays.sort(nums);
        int[] preSum = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum[i] = sum;
        }
        for (int i = 0; i < queries.length; i++) {
            int l = 0;
            int r = nums.length;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (preSum[mid] <= queries[i]) {
                    res[i] = Math.max(res[i], mid + 1);
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
        }
        return res;
    }

}
