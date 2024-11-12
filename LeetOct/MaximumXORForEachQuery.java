package LeetOct;

import java.util.Arrays;
import java.util.Collections;

public class MaximumXORForEachQuery {
    public static void main(String[] args) {
        int nums[] = { 2, 3, 4, 7 };
        int maximumBit = 3;
        System.out.println(getMaximumXor(nums, maximumBit));
    }

    public static int[] getMaximumXor(int[] nums, int maximumBit) {
        int preXOR[] = new int[nums.length];
        int res[] = new int[nums.length];
        int value = (1 << maximumBit) - 1;
        preXOR[0] = nums[0];
        res[res.length - 1] = nums[0] ^ value;
        for (int i = 1; i < nums.length; i++) {
            preXOR[i] = (preXOR[i - 1] ^ nums[i]);
            res[res.length - 1 - i] = preXOR[i] ^ value;
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

}
