package GreedyAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumPlatforms {
    public static void main(String[] args) {
        int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
        int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };

        System.out.println(minPlatforms(arr, dep));
    }

    static int minPlatforms(int[] arr, int[] dep) {
        // My code
        // int[][] combined = new int[arr.length][2];
        // for (int x = 0; x < arr.length; x++) {
        // combined[x] = new int[] { arr[x], dep[x] };
        // }

        // Arrays.sort(combined, (a, b) -> a[0] - b[0]);
        // List<Integer> list = new ArrayList<>();
        // int i = 1;
        // list.add(combined[0][1]);
        // while (i < combined.length) {
        // int flag = 0;
        // for (int x = 0; x < list.size(); x++) {
        // if (list.get(x) < combined[i][0]) {
        // list.set(x, combined[i][1]);
        // flag = 1;
        // break;
        // }
        // }
        // if (flag == 0) {
        // list.add(combined[i][1]);
        // }
        // i++;
        // }
        // return list.size();

        // Actual logic
        // Intution here is to just focus on arrival and departure

        Arrays.sort(arr);
        Arrays.sort(dep);

        int count = 0;
        int maxcount = 0;

        int i = 0;
        int j = 0;

        while (i < arr.length && j < dep.length) {
            if (arr[i] < dep[j]) {
                count++;
                i = i + 1;
            } else {
                count--;
                j = j + 1;
            }
            maxcount = Math.max(maxcount, count);
        }

        return maxcount;
    }
}
