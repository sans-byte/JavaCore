package Graphs;

import java.util.*;

public class DFS {
    public static void main(String[] args) {
        int adj[][] = { { 1, 2 }, { 0, 2 }, { 0, 1, 3, 4 }, { 2 }, { 2 } };
        List<Integer> res = dfsOfGraph(adj);
        System.out.println(res);
    }

    public static void dfs(int[][] adj, int current, List<Integer> res, int[] visited) {
        for (int i = 0; i < adj[current].length; i++) {
            int val = adj[current][i];
            if (visited[val] == 0) {
                visited[val] = 1;
                res.add(val);
                dfs(adj, val, res, visited);
            }
        }
    }

    public static ArrayList<Integer> dfsOfGraph(int[][] adj) {
        int start = 0;

        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);

        int visited[] = new int[adj.length];
        visited[0] = 1;

        dfs(adj, start, res, visited);
        return res;
    }
}
