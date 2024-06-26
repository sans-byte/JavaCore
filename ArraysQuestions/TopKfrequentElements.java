package ArraysQuestions;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/top-k-frequent-elements/
public class TopKfrequentElements {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3,5,5,5,5,5,1,1,1,1,3,3,3,3,3,3,3,8,8,8,8,9 };
        int k = 2;

        topKfrequentElements(nums, k);
    }

    static int[] topKfrequentElements(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(nums[i])) {
                int n = m.get(nums[i]);
                m.put(nums[i], n + 1);
            } else {
                m.put(nums[i], 1);
            }
        }

        System.out.println(m);

        return null;
    }
}
