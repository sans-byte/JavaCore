package ArraysQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

// https://leetcode.com/problems/3sum/description/

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        System.out.println(threeSum(nums));
    }

    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> twoSums = twoSum(nums, i + 1, nums[i]);
            if (twoSums.size() > 0) {
                for (List<Integer> sums : twoSums) {
                    sums.add(0, nums[i]);
                    res.add(sums);
                }
            }
        }
        for (List<Integer> i : res) {
            result.add(i);
        }
        return result;
    }

    static List<List<Integer>> twoSum(int[] numbers, int start, int sum) {
        int i = start;
        int j = numbers.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        int targetSum = 0;
        while (i < j) {
            targetSum = numbers[i] + numbers[j] + sum;
            if (targetSum == 0) {
                List<Integer> result = new ArrayList<>();
                result.add(numbers[i]);
                result.add(numbers[j]);
                res.add(result);
            }
            if (targetSum > 0)
                j--;
            else
                i++;
        }
        return res;
    }
}