package GFG160.Searching;

import java.util.*;

public class AggressiveCows {
    public static void main(String[] args) {
        // int stalls[] = { 2, 12, 11, 3, 26, 7 }, k = 5;
        // int stalls[] = { 1, 2, 4, 8, 9 }, k = 3;

        int stalls[] = { 31, 27, 8, 33, 32, 20, 7, 24, 23, 3, 26, 9 }, k = 7;
        System.out.println(aggressiveCows(stalls, k));
    }

    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        System.out.println(Arrays.toString(stalls));
        int l = 1;
        int r = stalls[stalls.length - 1] - stalls[0];
        int res = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            int count = 1;
            int sum = stalls[0] + mid;
            for (int x = 1; x < stalls.length; x++) {
                if (stalls[x] >= sum) {
                    sum = stalls[x] + mid;
                    count++;
                }
            }
            if (count >= k) {
                res = Math.max(res, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
