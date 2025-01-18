package GFG160.Prefix;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayOf0sand1s {
    public static void main(String[] args) {
        int arr[] = { 1, 0, 1, 1, 1, 0, 0 };
        System.out.println(maxLen(arr));
    }

    public static int maxLen(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                nums[i] = -1;
        }
        int prefix = 0;
        Map<Integer, Integer> m = new HashMap<>(0);
        m.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            if (m.containsKey(prefix)) {
                res = Math.max(res, i - m.get(prefix));
            }
            if (!m.containsKey(prefix))
                m.put(prefix, i);
        }
        return res;
    }
}
