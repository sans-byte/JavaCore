package GFG160;

import java.util.HashSet;
import java.util.Set;

public class SmallestPositiveMissingNumber {
    public static void main(String[] args) {
        // int arr[] = { 2, -3, 4, 1, 1, 7 };
        // int arr[] = { 100000, 3, 4000, 2, 15, 1, 99999 };
        int arr[] = { 3, 4, -1, 1 };
        System.out.println(missingNumber(arr));
        System.out.println(missingNumberBetter(arr));
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

    public static int missingNumberBetter(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] = 0;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0 && Math.abs(arr[i]) <= arr.length) {
                if (arr[Math.abs(arr[i]) - 1] == 0) {
                    continue;
                } else if (arr[Math.abs(arr[i]) - 1] <= 0) {
                    continue;
                } else {
                    arr[Math.abs(arr[i]) - 1] *= -1;
                }
            }
        }
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                return res;
            }
            res++;
        }
        return res;
    }
}
