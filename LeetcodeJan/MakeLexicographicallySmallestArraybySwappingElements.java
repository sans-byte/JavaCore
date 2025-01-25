package LeetcodeJan;

import java.util.Arrays;

public class MakeLexicographicallySmallestArraybySwappingElements {
    public static void main(String[] args) {
        int nums[] = { 1, 7, 6, 18, 2, 1 }, limit = 3;
        System.out.println(lexicographicallySmallestArray(nums, limit));
    }

    public static int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int res[] = new int[nums.length];
        int temp[][] = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = new int[] { nums[i], i };
        }

        Arrays.sort(temp, (x, y) -> Integer.compare(x[0], y[0]));

        for (int[] i : temp)
            System.out.println(Arrays.toString(i));
        return res;
    }
}
