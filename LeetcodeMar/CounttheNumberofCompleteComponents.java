package LeetcodeMar;

import java.util.*;

public class CounttheNumberofCompleteComponents {
    public static void main(String[] args) {
        int n = 6, edges[][] = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 3, 4 } };
        System.out.println(countCompleteComponents(n, edges));
    }

    public static int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return 0;
    }
}
