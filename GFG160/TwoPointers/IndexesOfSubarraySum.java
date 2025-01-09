package GFG160.TwoPointers;

import java.util.*;

public class IndexesOfSubarraySum {
    public static void main(String[] args) {
        // int arr[] = { 12, 18, 5, 11, 30, 5 }, target = 69;
        // int arr[] = { 26, 3, 28, 7 }, target = 52;
        // int arr[] = { 12 }, target = 12;
        // int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, target = 15;
        // int arr[] = { 1, 2, 3, 7, 5 }, target = 12;
        // int arr[] = {5, 3, 4}, target = 2;
        int arr[] = { 38, 22, 20, 12, 47, 23, 18, 13, 18, 47, 36, 42 }, target = 174;
        System.out.println(subarraySum(arr, target));
    }

    public static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int s = 0, e = 0;
        ArrayList<Integer> res = new ArrayList<>();

        int curr = 0;
        for (int i = 0; i < arr.length; i++) {
            curr += arr[i];
            if (curr >= target) {
                e = i;
                while (curr > target && s < e) {
                    curr -= arr[s];
                    ++s;
                }
                if (curr == target) {
                    res.add(s + 1);
                    res.add(e + 1);
                    return res;
                }
            }
        }
        res.add(-1);
        return res;
    }
}