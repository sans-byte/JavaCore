package GFG160;

import java.util.*;

public class InsertInterval {
    public static void main(String[] args) {
        int intervals[][] = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } },
        newInterval[] = { 4, 9 };
        // int intervals[][] = { { 0, 40 } }, newInterval[] = { 82, 97 };
        ArrayList<int[]> res = insertInterval(intervals, newInterval);
        for (int[] i : res) {
            System.out.println(Arrays.toString(i));
        }
    }

    // private static ArrayList<int[]> mergeIntervals(ArrayList<int[]> arr) {
    // if (arr.size() <= 1)
    // return arr;
    // ArrayList<int[]> ans = new ArrayList<>();

    // int[] current = arr.get(0);
    // ans.add(current);

    // for (int[] a : arr) {
    // int currentLast = current[1];
    // int nextStart = a[0];
    // int nextEnd = a[1];

    // if (currentLast >= nextStart) {
    // current[1] = Math.max(currentLast, nextEnd);
    // } else {
    // current = a;
    // ans.add(current);
    // }
    // }

    // return ans;
    // }

    // public static ArrayList<int[]> insertInterval(int[][] intervals, int[]
    // newInterval) {
    // ArrayList<int[]> res = new ArrayList<>();
    // for (int[] i : intervals)
    // res.add(i);
    // int i = 0;
    // while (i < intervals.length && intervals[i][0] < newInterval[0]) {
    // i++;
    // }
    // res.add(i, newInterval);
    // return mergeIntervals(res);
    // }

    public static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        int minValue = newInterval[0];
        int maxValue = newInterval[1];

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            minValue = Math.min(minValue, intervals[i][0]);
            maxValue = Math.max(maxValue, intervals[i][1]);
            i++;
        }

        res.add(new int[] { minValue, maxValue });
        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }

        return res;
    }
}
