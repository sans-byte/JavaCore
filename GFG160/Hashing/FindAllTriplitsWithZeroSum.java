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

        // return res;

        Set<List<Integer>> set = new HashSet<>();
        Map<Integer, List<int[]>> map = new HashMap<>(); // arr[a] + arr[b] = -arr[c] // we will store all a and b here

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                map.computeIfAbsent(arr[i] + arr[j], k -> new ArrayList<>()).add(new int[] { i, j });
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int value = -arr[i];
            int index = i;
            if (map.containsKey(value)) {
                for (int[] pair : map.get(value)) {
                    if (pair[0] != i && pair[1] != i) {
                        List<Integer> temp = new ArrayList<>() {
                            {
                                add(pair[0]);
                                add(pair[1]);
                                add(index);
                            }
                        };

                        Collections.sort(temp);
                        set.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}