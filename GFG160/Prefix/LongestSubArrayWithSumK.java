package GFG160.Prefix;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        // int arr[] = { -5, 8, -14, 2, 4, 12 }, k = -5;
        int arr[] = { 10 }, k = 10;
        System.out.println(longestSubarray(arr, k));
    }

    public static int longestSubarray(int[] arr, int k) {
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = arr[i] + prefix[i - 1];
        }
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 0);
        int count = 0;
        for (int i = 0; i < prefix.length; i++) {
            int val = prefix[i] - k;
            if (m.containsKey(val)) {
                count = Math.max(count, i - m.get(val) + 1);
            }
            if (!m.containsKey(prefix[i])) {
                m.put(prefix[i], i + 1);
            }
        }
        return count;
    }
}
