import java.util.*;

public class FindMinimumDiameterAfterMergingTwoTrees {
    public static void main(String[] args) {
        // int edges1[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 4 }, { 2, 5 }, { 3, 6
        // }, { 2, 7 } },
        // edges2[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 4 }, { 2, 5 }, { 3, 6 }, {
        // 2, 7 } };

        int edges1[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 } };
        int edges2[][] = { { 0, 1 } };

        // int edges1[][] = { { 0, 1 }, { 2, 0 }, { 3, 2 }, { 3, 6 }, { 8, 7 }, { 4, 8
        // }, { 5, 4 }, { 3, 5 }, { 3, 9 } };
        // int edges2[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 } };

        System.out.println(minimumDiameterAfterMerge(edges1, edges2));
    }

    public static void dfs(List<List<Integer>> edges, int curr, int parent, int distance, int[] res) {

        if (distance > res[0]) {
            res[0] = distance;
            res[1] = curr;
        }

        for (int i : edges.get(curr)) {
            if (i != parent) {
                dfs(edges, i, curr, distance + 1, res);
            }
        }
    }

    public static int helper(int[][] edges) {
        List<List<Integer>> l = new ArrayList<>();
        int n = edges.length + 1;
        for (int i = 0; i <= n; i++) {
            l.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            l.get(edges[i][0]).add(edges[i][1]);
            l.get(edges[i][1]).add(edges[i][0]);
        }

        int distanceAndExtremeNode[] = { Integer.MIN_VALUE, -1 };
        dfs(l, 0, -1, 0, distanceAndExtremeNode);
        dfs(l, distanceAndExtremeNode[1], -1, 0, distanceAndExtremeNode);

        System.out.println(Arrays.toString(distanceAndExtremeNode));
        return distanceAndExtremeNode[0];
    }

    public static int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int value1 = helper(edges1);
        int value2 = helper(edges2);

        int diameter = (int) (Math.ceil(value1 / 2.0) + Math.ceil(value2 / 2.0)) + 1;
        return Math.max(diameter, Math.max(value1, value2));
    }
}
