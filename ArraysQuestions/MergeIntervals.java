package ArraysQuestions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

        int[][] mergedIntervals = mergeIntervals(intervals);
        for (int[] i : mergedIntervals) {
            System.out.println(Arrays.toString(i));
        }
    }

    static int[][] mergeIntervals(int[][] arr) {
        if (arr.length <= 1)
            return new int[0][];
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();

        int[] current = arr[0];
        ans.add(current);

        for (int[] a : arr) {
            int currentLast = current[1];
            int nextStart = a[0];
            int nextEnd = a[1];

            if (currentLast >= nextStart) {
                current[1] = Math.max(currentLast, nextEnd);
            } else {
                current = a;
                ans.add(current);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
