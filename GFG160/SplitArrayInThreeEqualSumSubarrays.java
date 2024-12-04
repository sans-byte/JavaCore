package GFG160;

import java.util.*;

public class SplitArrayInThreeEqualSumSubarrays {
    public static void main(String[] args) {
        // int arr[] = { 1, 3, 4, 0, 4 };
        // int arr[] = { 0, 1, 1 };
        // int arr[] = { 1, 1, 0 };
        // int arr[] = { 2, 2, 6, 1, 5, 4, 2, 4, 5, 2, 1, 3, 6, 1, 5, 1, 2, 2 };
        int arr[] = { 6, 5, 1, 6, 6, 1, 1, 2, 3, 5 };
        // int arr[] = { 1, 1, 1 };
        System.out.println(findSplit(arr));
    }

    public static List<Integer> findSplit(int[] arr) {
        // Return an array of possible answer, driver code will judge and return true or
        // false based on
        List<Integer> res = new ArrayList<>();
        int total = Arrays.stream(arr).sum();
        int i = 0;
        int j = arr.length - 1;
        int sumI = 0;
        int sumJ = 0;

        while (i <= j) {
            if (sumI < sumJ) {
                sumI += arr[i];
                i++;
            } else if (sumJ < sumI) {
                sumJ += arr[j];
                j--;
            } else {
                int tempTotal = total - sumI - sumJ;
                System.out.println(tempTotal);
                if (sumI == tempTotal) {
                    res.add(i - 1);
                    res.add(j);
                    break;
                } else {
                    sumI += arr[i];
                    sumJ += arr[j];
                    i++;
                    j--;
                }
            }
        }

        if (res.isEmpty()) {
            return new ArrayList<>() {
                {
                    add(-1);
                    add(-1);
                }
            };
        }

        return res;
    }
}
