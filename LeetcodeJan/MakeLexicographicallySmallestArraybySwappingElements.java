package LeetcodeJan;

import java.util.*;

public class MakeLexicographicallySmallestArraybySwappingElements {
    public static void main(String[] args) {
        int nums[] = { 1, 7, 6, 18, 2, 1 }, limit = 3;
        System.out.println(Arrays.toString(lexicographicallySmallestArray(nums, limit)));
    }

    public static int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int res[] = new int[nums.length];
        int temp[][] = new int[nums.length][2];
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            temp[i] = new int[] { nums[i], i };
        }
        Arrays.sort(temp, (x, y) -> Integer.compare(x[0], y[0]));
        l.add(new ArrayList<>(Arrays.asList(temp[0][1])));
        for (int i = 1; i < temp.length; i++) {
            if (temp[i][0] - temp[i - 1][0] <= limit)
                l.get(l.size() - 1).add(temp[i][1]);
            else {
                l.add(new ArrayList<>(Arrays.asList(temp[i][1])));
            }
        }
        for (int i = 0; i < l.size(); i++) {
            Collections.sort(l.get(i));
        }
        int index = 0;
        for (List<Integer> groups : l) {
            for (int pos : groups) {
                res[pos] = temp[index++][0];
            }
        }
        return res;
    }
}
