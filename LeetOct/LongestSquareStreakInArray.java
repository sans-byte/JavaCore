package LeetOct;

import java.util.*;

// 2501. Longest Square Streak in an Array

public class LongestSquareStreakInArray {
    public static void main(String[] args) {
        int nums[] = { 2, 3, 5, 6, 7 };
        System.out.println(longestSquareStreak(nums));
    }

    public static int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> m = new HashMap<>();
        int res = -1;

        for (int num : nums) {
            int sqrt = (int) Math.sqrt(num);
            if (sqrt * sqrt == num && m.containsKey(sqrt)) {
                System.out.println(num);
                m.put(num, m.get(sqrt) + 1);
                res = Math.max(m.get(num), res);
            } else {
                m.put(num, 1);
            }
        }
        return res;
    }

}
