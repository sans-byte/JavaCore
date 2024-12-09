package LeetcodeDec;

import java.util.*;

public class SpecialArrayII {
    public static void main(String[] args) {
        int nums[] = { 4, 3, 1, 6 }, queries[][] = { { 0, 2 }, { 2, 3 } };
        System.out.println(Arrays.toString(isArraySpecial(nums, queries)));
    }

    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int prefix[] = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1];
            if (nums[i - 1] % 2 == 0 && nums[i] % 2 == 0 || nums[i - 1] % 2 != 0 && nums[i] % 2 != 0) {
                prefix[i]++;
            }
        }

        boolean res[] = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = prefix[queries[i][1]] - prefix[queries[i][0]] == 0;
        }
        return res;
    }
}
