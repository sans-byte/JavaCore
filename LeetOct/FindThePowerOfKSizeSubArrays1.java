package LeetOct;

import java.util.*;

public class FindThePowerOfKSizeSubArrays1 {
    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 3, 2, 5 }, k = 3;
        System.out.println(Arrays.toString(resultsArray(nums, k)));
    }

    public static int[] resultsArray(int[] nums, int k) {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i <= nums.length - k; i++) {
            boolean flag = true;
            for (int j = i + 1; j < i + k; j++) {
                if (nums[j] == nums[j - 1] + 1) {
                    l.add(-1);
                    flag = false;
                    break;
                }
            }
            if (flag)
                l.add(nums[i + k - 1]);
        }
        int res[] = new int[l.size()];
        for (int i = 0; i < l.size(); i++)
            res[i] = l.get(i);
        return res;
    }
}
