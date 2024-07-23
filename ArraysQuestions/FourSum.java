package ArraysQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/4sum/description/

public class FourSum {

    public static void main(String[] args) {
        // int[] nums = { 1, 0, -1, 0, -2, 2 };
        // int[] nums = { 2, 2, 2, 2, 2 };
        int[] nums = { 1000000000, 1000000000, 1000000000, 1000000000 };
        int target = -294967296;

        System.out.println(fourSum(nums, target));
    }

    static List<List<Integer>> fourSum(int[] nums, int target) {
        // Intution here is to implement 3 sum in third loop so the over all complexity
        // will be around n^3;
        // for k num the minimum time complexity will be n^k-1
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    List<Integer> temp = new ArrayList<>();
                    long sum = (long) nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target) {
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[start]);
                        temp.add(nums[end]);
                        res.add(temp);
                        start++;
                        end--;
                    } else if (sum < target) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(res);
        return result;
    }

}
