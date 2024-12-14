package LeetcodeDec;

import java.util.*;

public class ContiniousSubarrays {
    public static void main(String[] args) {
        int nums[] = { 5, 4, 2, 4 };
        System.out.println(continuousSubarrays(nums));
    }

    public static long continuousSubarrays(int[] nums) {
        long res = 0;

        TreeMap<Integer, Integer> sortedMap = new TreeMap<>(); // this gives us a sorted map
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            sortedMap.merge(nums[j], 1, Integer::sum);
            while (!sortedMap.isEmpty() && sortedMap.lastKey() - sortedMap.firstKey() > 2) {
                sortedMap.put(nums[i], sortedMap.get(nums[i]) - 1);
                if (sortedMap.get(nums[i]) == 0) {
                    sortedMap.remove(nums[i]);
                }
                i++;
            }
            res += j - i + 1;
            j++;
        }

        return res;
    }

    // second approch with the help of double ended queue

    
}
