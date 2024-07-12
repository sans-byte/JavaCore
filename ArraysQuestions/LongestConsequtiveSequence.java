package ArraysQuestions;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/

public class LongestConsequtiveSequence {
    public static void main(String[] args) {

        int[] nums = { 100, 4, 200, 1, 3, 2, 2, 2, 2, 2, 1, 11, 1, 1, 1 };
        System.out.println(findLongestConsequtiveSequence(nums));
    }

    static int findLongestConsequtiveSequence(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int n : nums) {
            s.add(n);
        }

        int maxCount = 0;
        for (int i : s) {
            int count = 0;
            if (!s.contains(i - 1)) {
                count++;
                int x = i;
                while (s.contains(x + 1)) {
                    count++;
                    x = x + 1;
                }
            }
            maxCount = Math.max(count, maxCount);
        }

        System.out.println(s);
        return maxCount;
    }

}
