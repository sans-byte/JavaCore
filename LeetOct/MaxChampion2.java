package LeetOct;

import java.util.HashSet;
import java.util.Set;

public class MaxChampion2 {
    public static void main(String[] args) {
        int n = 3, edges[][] = { { 0, 1 }, { 1, 2 } };
        System.out.println(findChampion(n, edges));
        System.out.println(findChampionWithArray(n, edges));
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

    public static int findChampionWithArray(int n, int[][] edges) {
        int temp[] = new int[n];
        for (int[] row : edges) {
            temp[row[1] - 1]++;
        }
        int res = -1;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0 && res != -1) {
                return -1;
            }
            if (temp[i] == 0) {
                res = temp[i];
            }
        }
        return res;
    }
}
