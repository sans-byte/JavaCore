package LeetOct;

import java.util.List;
import java.util.ArrayList;

// https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/description/?envType=daily-question&envId=2024-10-18

// When we are asked to compute the maximum bitwise OR of subsets and count how many subsets achieve this maximum, the problem essentially boils down to finding the largest possible OR value. Since OR operations are cumulative (meaning that once a bit is set, it stays set), the more elements we include in a subset, the closer we get to the maximum possible OR

// So the or of all the elements in an array will be the largest or an array elemnts could achieve 

public class CountNumberOfMaxXORSubsets {
    public static void main(String[] args) {
        int nums[] = { 3, 2, 1, 5 };
        System.out.println(countNumberWithBacktracking(nums));
        // System.out.println(countMAX(nums));
        // System.out.println(countMaxOrSubsets(nums));

        // below code is just to play with creating power set ignore for quetion
        // List<List<Integer>> l = new ArrayList<>();
        // List<Integer> res = new ArrayList<>();
        // getPowerSetWithRecursion(0, nums, l, res);
    }

    static public int countMAX(int[] nums) {
        int count = 0;
        // Calculate the max or ( just or all the elements )
        int maxOr = 0;
        for (int i : nums) {
            maxOr |= i;
        }
        // calculate power set and increase count

        int maxLengthOfPowerSet = (int) Math.pow(2, nums.length);
        for (int i = 0; i < maxLengthOfPowerSet; i++) {
            int x = 0;
            int or = 0;
            while (x < nums.length) {
                if ((i & (1 << x)) != 0) {
                    or |= nums[x];
                }
                x++;
            }
            if (or == maxOr) {
                count++;
            }
        }
        return count;
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

    static public int countNumberWithBacktracking(int[] nums) {
        int maxOr = 0;
        for (int i : nums) {
            maxOr |= i;
        }
        int[] count = new int[1];
        // we need to exclude and include one elemnet at each recursion call to get all
        // the subsets and need to check if that it equal to the maxOr
        backTracking(nums, 0, 0, count, maxOr);
        return count[0];
    }

    static public void backTracking(int[] nums, int index, int or, int[] count, int maxOr) {
        if (index == nums.length) {
            if (maxOr == or) {
                count[0]++;
            }
            return;
        }
        // excluding
        backTracking(nums, index + 1, or, count, maxOr);
        // including
        backTracking(nums, index + 1, or | nums[index], count, maxOr);
    }

    // the upper function can also be written as - 
    // static public void backTracking(int[] nums, int index, int or, int[] count, int maxOr) {
    //     if (maxOr == or) {
    //         count[0]++;
    //         return;
    //     }
    //     // excluding will be handled by for loop as it internally goes to the next element without considering it
    //     for(int i = index; i < nums.length; i++){
    //         // including
    //         backTracking(nums, i + 1, or | nums[i], count, maxOr);
    //     }
    // }

}
