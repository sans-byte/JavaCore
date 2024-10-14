package ArraysQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;

// https://leetcode.com/problems/3sum/description/

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        System.out.println(threeSumOptimised(nums));
    }

    // Intution here is to pick one one element from the array and apply 2sum on the
    // remaining array
    // Which will give you all the 3sums
    // Below is easy to underatand function wise implementation of it

    // The time complexity for 3 sum will be around n^2

    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> twoSums = twoSum(nums, i + 1, nums[i]);
            if (twoSums.size() > 0) {
                // for (List<Integer> sums : twoSums) {
                //     sums.add(0, nums[i]);
                //     res.add(sums);
                // }
                res.addAll(twoSums);
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
                result.add(sum);
                res.add(result);
            }
            if (targetSum > 0)
                j--;
            else
                i++;
        }
        return res;
    }
    // Here I'll try to write more optimised code

    static List<List<Integer>> threeSumOptimised(int[] arr) {
        Arrays.sort(arr);
        Set<List<Integer>> res = new LinkedHashSet<>();
        int k = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = k - 1;

            while (l < r) {
                int target = arr[i] + arr[r] + arr[l];
                if (target == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[l]);
                    temp.add(arr[r]);
                    res.add(temp);
                    l++;
                    r--;
                } else if (target > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(res);
        return result;
    }
}