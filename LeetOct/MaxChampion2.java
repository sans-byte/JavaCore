package LeetOct;

import java.util.HashSet;
import java.util.Set;

public class MaxChampion2 {
    public static void main(String[] args) {
        int n = 3, edges[][] = { { 0, 1 }, { 1, 2 } };
        System.out.println(findChampion(n, edges));
    }

    public static int findChampion(int n, int[][] edges) {
        Set<Integer> s = new HashSet<>();
        for (int[] row : edges) {
            s.add(row[1]);
        }
        if (s.size() < n - 1)
            return -1;
        int res = ((n - 1) * (n)) / 2;
        for (int i : s) {
            res -= i;
        }
        return res;
    }
}
