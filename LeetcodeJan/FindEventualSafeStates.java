package LeetcodeJan;

import java.util.*;

public class FindEventualSafeStates {
    public static void main(String[] args) {
        int graph[][] = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
        System.out.println(eventualSafeNodes(graph));
    }

    public static boolean isSafe(int[][] graph, int node, int[] state) {
        if (state[node] != 0) {
            return state[node] == 2;
        }

        state[node] = 1;

        for (int neighbours : graph[node]) {
            if (!isSafe(graph, neighbours, state)) {
                return false;
            }
        }

        state[node] = 2;
        return true;
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int state[] = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (isSafe(graph, i, state))
                res.add(i);
        }
        return res;
    }
}
