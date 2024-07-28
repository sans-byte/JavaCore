package GreedyAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervals {
    public static void main(String[] args) {
        // int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[][] intervals = { { 1, 3 }, { 6, 9 } };
        // int[] newInterval = { 4, 8 };
        int[] newInterval = { 2, 5 };

        int[][] res = insertInterval(intervals, newInterval);
        for (int[] i : res) {
            System.out.println(Arrays.toString(i));
        }
    }

    static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            if (intervals[i][1] < newInterval[0]) {
                res.add(intervals[i]);
                i = i + 1;
            } else {
                break;
            }
        }
        int max = newInterval[1];
        int min = newInterval[0];

        while (i < intervals.length) {
            if (intervals[i][0] <= newInterval[1]) {
                max = Math.max(max, intervals[i][1]);
                min = Math.min(min, intervals[i][0]);
                i = i + 1;
            } else {
                break;
            }
        }
        res.add(new int[] { min, max });

        while (i < intervals.length) {
            res.add(intervals[i]);
            i = i + 1;
        }

        int[][] result = new int[res.size()][];

        for (int x = 0; x < res.size(); x++)
            result[x] = res.get(x);

        return result;
    }
}
