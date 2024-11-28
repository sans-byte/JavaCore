package Graphs;

import java.util.Arrays;

public class BFS {
    public static void main(String[] args) {
        int adj[][] = { { 1, 2 }, { 0, 2 }, { 0, 1, 3, 4 }, { 2 }, { 2 } }; // adjacency list
        int start = 0;
        int bfs[] = bfs(adj, start);
        System.out.println(Arrays.toString(bfs));
    }

    public static int[] bfs(int[][] adj, int start) {
        int[] visited = new int[adj.length];
        return null;
    }
}
