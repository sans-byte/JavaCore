package LeetOct;

import java.util.*;

public class ShortestDistanceAfterRoadAddition1 {
    public static void main(String[] args) {
        int n = 5, queries[][] = { { 2, 4 }, { 0, 2 }, { 0, 4 } };
        System.out.println(Arrays.toString(shortestDistanceAfterQueries(n, queries)));
    }

    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(i + 1);
            adj.add(temp);
        }
        return querySolver(adj, n, queries);
    }

    public static int[] querySolver(List<List<Integer>> adj, int n, int[][] queries) {
        int res[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            adj.get(queries[i][0]).add(queries[i][1]);
            res[i] = bfs(adj, n);
        }
        return res;
    }

    public static int bfs(List<List<Integer>> adj, int n) {
        int visited[] = new int[n];
        visited[0] = 1;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        int distance = 0;
        int minDistance = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int len = q.size();
            distance++;
            for (int i = 0; i < len; i++) {
                int val = q.poll();
                for (int x : adj.get(val)) {
                    if (visited[x] == 0) {
                        if (x == n - 1) {
                            minDistance = Math.min(minDistance, distance);
                        } else {
                            visited[x] = 1;
                            q.add(x);
                        }
                    }
                }
            }
        }
        return minDistance;
    }
}
