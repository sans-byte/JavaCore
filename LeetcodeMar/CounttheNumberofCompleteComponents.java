package LeetcodeMar;

import java.util.*;

public class CounttheNumberofCompleteComponents {
    public static void main(String[] args) {
        int n = 6, edges[][] = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 3, 4 } };
        System.out.println(countCompleteComponents(n, edges));
    }

    public static void dfs(int u, List<List<Integer>> adj, int[] visited, int degreeSum, int nodes) {
        visited[u] = 1;
        nodes++;
        degreeSum = adj.get(u).size();
        for (int v : adj.get(u)) {
            if (visited[v] == 0)
                dfs(v, adj, visited, degreeSum, nodes);
        }
    }

    public static int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int visited[] = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] != 0)
                continue;
            int degreeSum = 0, nodes = 0;
            dfs(i, adj, visited, degreeSum, nodes);
            if (degreeSum == nodes * (nodes - 1))
                ans++;
        }
        return ans;
    }
}
