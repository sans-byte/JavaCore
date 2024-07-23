package ArraysQuestions;

import java.util.HashMap;
import java.util.Map;

// https://www.interviewbit.com/problems/subarray-with-given-xor/

public class SubArraysWithGivenXOR {
    public static void main(String[] args) {
        int[] arr = { 4, 2, 2, 6, 4 };
        int target = 6;
        System.out.println(numberOfSubarrayWithGivenTarget(arr, target));
    }

    static int numberOfSubarrayWithGivenTarget(int[] arr, int target) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int xor = 0;

        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
            int value = target ^ xor;
            if (map.containsKey(value)) {
                count += map.get(value);
            }
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }

}
