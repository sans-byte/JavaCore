package LeetOct;

import java.util.List;
import java.util.ArrayList;

public class CountNumberOfMaxXORSubsets {
    public static void main(String[] args) {
        int nums[] = { 3, 2, 1, 5 };
        // System.out.println(countMaxOrSubsets(nums));

        List<List<Integer>> l = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        getPowerSetWithRecursion(0, nums, l, res);
    }

    static public int countMaxOrSubsets(int[] nums) {
        // lets first try to all the power sets in an array with the help of bit
        // manupilation method

        List<List<Integer>> powerSet = getPowerSet(nums);
        List<Integer> ors = new ArrayList<>();
        for (List<Integer> i : powerSet) {
            int or = 0;
            for (int x : i) {
                or |= x;
            }
            ors.add(or);
        }
        ors.sort((x, y) -> y - x);
        int count = 1;
        System.out.println(ors);
        for (int i = 1; i < ors.size(); i++) {
            int val = ors.get(i);
            int val2 = ors.get(i - 1);
            if (val == val2) {
                System.out.println("here");
                count++;
            } else
                break;
        }
        return count;
    }

    static public List<List<Integer>> getPowerSet(int[] nums) {
        List<List<Integer>> ps = new ArrayList<>();
        int numberOfSets = (int) (Math.pow(2, nums.length) - 1);
        for (int i = 0; i <= numberOfSets; i++) {
            List<Integer> set = new ArrayList<>();
            int x = 0;
            while (x < nums.length) {
                if ((i & (1 << x)) != 0) {
                    set.add(nums[x]);
                }
                x++;
            }
            ps.add(set);
        }
        return ps;
    }

    static public void getPowerSetWithRecursion(int i, int[] nums, List<List<Integer>> result, List<Integer> res) {
        if (i >= nums.length) {
            result.add(new ArrayList<>(res));
            System.out.println(res);
            return;
        }
        res.add(nums[i]);
        getPowerSetWithRecursion(i + 1, nums, result, res);
        res.remove(res.size() - 1);
        getPowerSetWithRecursion(i + 1, nums, result, res);
    }
}
