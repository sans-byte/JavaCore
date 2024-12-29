package GFG160.Hashing;

import java.util.*;

public class FindAllTriplitsWithZeroSum {
    public static void main(String[] args) {
        int arr[] = { 0, -1, 2, -3, 1 };
        System.out.println(findTriplets(arr));
    }

    public static List<List<Integer>> findTriplets(int[] arr) {
        // This code is failing for 1 test case idk why
        
        // List<List<Integer>> res = new ArrayList<>();
        // for (int i = 0; i < arr.length - 2; i++) {
        // int target = 0 - arr[i];
        // Map<Integer, Integer> m = new HashMap<>();
        // for (int j = i + 1; j < arr.length; j++) {
        // int val = target - arr[j];
        // if (m.containsKey(val)) {
        // List<Integer> temp = new ArrayList<>();
        // temp.add(i);
        // temp.add(m.get(val));
        // temp.add(j);
        // Collections.sort(temp);
        // res.add(temp);
        // } else {
        // m.put(arr[j], j);
        // }
        // }

        // }

        return res;
    }
}