import java.util.*;

public class FindMinimumDiameterAfterMergingTwoTrees {
    public static void main(String[] args) {
        // int edges1[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 4 }, { 2, 5 }, { 3, 6
        // }, { 2, 7 } },
        // edges2[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 4 }, { 2, 5 }, { 3, 6 }, {
        // 2, 7 } };

        // int edges1[][] = { { 1, 0 }, { 1, 2 }, { 1, 3 } };
        // int edges2[][] = { { 3, 0 }, { 1, 2 }, { 4, 1 }, { 3, 4 } };

        int edges1[][] = { { 0, 1 }, { 2, 0 }, { 3, 2 }, { 3, 6 }, { 8, 7 }, { 4, 8 }, { 5, 4 }, { 3, 5 }, { 3, 9 } };
        int edges2[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 } };

        System.out.println(minimumDiameterAfterMerge(edges1, edges2));
    }

    public static int bfs(List<List<Integer>> edges, int root, boolean[] visited) {
        visited[root] = true;
        int res = 0;
        for (int i : edges.get(root)) {
            if (visited[i] == false) {
                res = Math.max(res, 1 + bfs(edges, i, visited));
            }
        }
        return res;
    }

    public static int[] helper(int[][] edges1) {
        List<List<Integer>> l = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < edges1.length; i++) {
            max = Math.max(max, Math.max(edges1[i][0], edges1[i][1]));
        }
        for (int i = 0; i <= max; i++) {
            l.add(new ArrayList<>());
        }

        for (int i = 0; i < edges1.length; i++) {
            l.get(edges1[i][0]).add(edges1[i][1]);
            l.get(edges1[i][1]).add(edges1[i][0]);
        }
        System.out.println(l);
        int minDistance = max;
        int maxDistance = 0;
        for (int i = 0; i <= max; i++) {
            boolean visited[] = new boolean[max + 1];
            int val = bfs(l, i, visited);
            maxDistance = Math.max(maxDistance, val);
            minDistance = Math.min(minDistance, val);
        }
        return new int[] { minDistance, maxDistance };
    }

    public static int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int values1[] = helper(edges1);
        int values2[] = helper(edges2);

        int diameter = values1[0] + values2[0] + 1;

        return Math.max(diameter, Math.max(values1[1], values2[1]));
    }
}
