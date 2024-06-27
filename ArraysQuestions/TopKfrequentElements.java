package ArraysQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/top-k-frequent-elements/
public class TopKfrequentElements {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 3, 5, 5, 5, 5, 5, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 8, 8, 8, 8, 9 };
        int k = 2;

        System.out.println(Arrays.toString(topKfrequentElements(nums, k)));
    }

    static int[] topKfrequentElements(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1); // This will on every occurence of an element increase the count
                                                    // with 1.
        }
        ArrayList<Integer>[] list = new ArrayList[nums.length + 1];

        for (int key : m.keySet()) {
            int freq = m.get(key);
            if (list[freq] == null) {
                list[freq] = new ArrayList<>();
            }
            list[freq].add(key);
        }

        System.out.println(Arrays.toString(list));

        int[] res = new int[k];

        int tracker = 0;

        for (int i = list.length - 1; i > 0; i--) {
            if (list[i] == null)
                continue;
            for (int j = 0; j < list[i].size(); j++) {
                res[tracker] = list[i].get(j);
                tracker++;
                if (tracker == k)
                    return res;
            }
        }
        
        return res;
    }
}
