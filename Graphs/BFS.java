package Graphs;

import java.util.*;

import DP.countNumberOfSquares;

public class BFS {
    public static void main(String[] args) {
        int adj[][] = { { 1, 2 }, { 0, 2 }, { 0, 1, 3, 4 }, { 2 }, { 2 } }; // adjacency list
        int start = 0;
        int bfs[] = bfs(adj, start);
        System.out.println(Arrays.toString(bfs));
    }

    public static int[] bfs(int[][] adj, int start) {
        int visited[] = new int[adj.length];
        visited[start] = 1;
        int res[] = new int[adj.length];
        res[0] = start;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        int index = 1;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int val = q.poll();
                for (int x : adj[val]) {
                    if (visited[x] == 0) {
                        q.add(x);
                        visited[x] = 1;
                        res[index] = x;
                        index++;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(visited));
        return res;
    }
}
