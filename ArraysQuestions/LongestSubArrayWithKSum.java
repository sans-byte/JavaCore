package ArraysQuestions;

import java.util.HashMap;

// https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1

// So the intution here is to keep pre sum and do some reverse engineering https://www.youtube.com/watch?v=frf7qxiN2qU

public class LongestSubArrayWithKSum {

    public static void main(String[] args) {
        int[] arr = { 10, 5, 2, 7, 1, 9 };
        int k = 15;

        System.out.println(lenOfLongSubarr(arr, k));
    }

    public static int lenOfLongSubarr(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxlen = 0;
        int count = 0; // if in the question they have asked for the number of subarrays with this sum
        for (int i = 0; i < arr.length; i++) {
            int len = 0;
            sum += arr[i];
            if (sum == k) {
                len = i + 1;
                maxlen = Math.max(maxlen, len);
                count++;
            } else if (map.containsKey(sum - k)) {
                len = i - map.get(sum - k);
                count++;
                maxlen = Math.max(maxlen, len);
            }
            if (!map.containsKey(sum)) { // We need this check so that value of maps does not change if array contains
                                         // value 0;
                map.put(sum, i);
            }
        }
        return maxlen;
    }
}
