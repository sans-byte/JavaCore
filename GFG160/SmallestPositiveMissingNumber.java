package GFG160;

import java.util.HashSet;
import java.util.Set;

public class SmallestPositiveMissingNumber {
    public static void main(String[] args) {
        int arr[] = { 2, -3, 4, 1, 1, 7 };
        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int[] arr) {
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0)
                s.add(arr[i]);
        }
        int res = 0;
        int i = 0;
        while (i < s.size()) {
            res++;
            if (!s.contains(res)) {
                return res;
            }
            i++;
        }
        return res + 1;
    }
}
