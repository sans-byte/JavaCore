package LeetOct;

import java.util.*;

// 659. Split Array into Consecutive Subsequences

public class SplitArrayIntoConsequtiveSubsequence {
    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 3, 4, 4, 5, 6 };
        int track[] = new int[nums.length];
        Set<List<Integer>> l = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        isPossible(nums, track, l, temp, 0);
        System.out.println(l);
    }

    public static void isPossible(int[] nums, int[] track, Set<List<Integer>> res, List<Integer> temp, int i) {

        if (temp.size() > 1 && (temp.get(temp.size() - 1) != temp.get(temp.size() - 2) + 1)) {
            return;
        }

        if (i >= nums.length) {
            System.out.println(temp);
            if (temp.size() == 4) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }

        temp.add(nums[i]);
        isPossible(nums, track, res, temp, i + 1);
        temp.remove(temp.size() - 1);
        isPossible(nums, track, res, temp, i + 1);

    }
}
