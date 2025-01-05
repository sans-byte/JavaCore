package GFG160.TwoPointers;

import java.util.*;

public class CountPairsWhoseSumIsLessThanTarget {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5, 2, 2, 2, 3, 3, 3, 2, 4, 1, 1, 1);
        int target = 6;
        System.out.println(countPairs(nums, target));
    }

    public static int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int count = 0;
        int i = 0, j = nums.size() - 1;
        while (i < j) {
            if (nums.get(i) + nums.get(j) < target) {
                // while (i < j && nums.get(i) == nums.get(i + 1)) {
                //     i++;
                //     count++;
                // }
                // while (j > i && nums.get(j) == nums.get(j - 1)) {
                //     j--;
                //     count++;
                // }
                count += j - i;
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
}
