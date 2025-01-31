package Graphs;

import java.util.*;

public class BipertiteGraph {
    public static void main(String[] args) {
        List<List<Integer>> adj = List.of(Arrays.asList(2, 3), Arrays.asList(2), Arrays.asList(0, 1, 3),
                Arrays.asList(0, 2));
        System.out.println(isBipartite(adj));
    }

    public static boolean dfs(List<List<Integer>> adj, int color, int[] colors, int node) {
        colors[node] = color;
        for (int i = 0; i < adj.get(node).size(); i++) {
            int currNode = adj.get(node).get(i);
            if (colors[currNode] == 0) {
                return dfs(adj, 3 - color, colors, currNode);
            } else if (colors[currNode] == color) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBipartite(List<List<Integer>> adj) {
        int colors[] = new int[adj.size()];
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == 0) {
                if (!dfs(adj, 1, colors, i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
