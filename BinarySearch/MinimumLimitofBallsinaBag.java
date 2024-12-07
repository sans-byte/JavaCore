package BinarySearch;

import java.util.*;

//TODO: revisit

public class MinimumLimitofBallsinaBag {
    public static void main(String[] args) {
        int nums[] = { 2, 4, 8, 2 }, maxOperations = 4;
        System.out.println(minimumSize(nums, maxOperations));
    }

    public static int minimumSize(int[] nums, int maxOperations) {
        int l = 1, r = Arrays.stream(nums).max().getAsInt();

        while (l < r) {
            int mid = (l + r) / 2;
            int ops = 0;
            for (int n : nums) {
                ops += (n - 1) / mid; // basically (ciel of n/mid) - 1
            }
            if (ops <= maxOperations)
                r = mid;
            else
                l = mid + 1;
        }
        return r;
    }
}
