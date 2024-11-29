package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class NumberOfProviences {

    public static void main(String[] args) {
        int isConnected[][] = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        // int isConnected[][] = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
        // int isConnected[][] = { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } };
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        int res = 0;
        int visited[] = new int[isConnected.length];

        for (int v = 0; v < visited.length; v++) {
            if (visited[v] == 0) {
                res++;
                visited[v] = 1;
                Queue<Integer> q = new LinkedList<>();
                q.add(v);
                while (!q.isEmpty()) {
                    int len = q.size();
                    for (int i = 0; i < len; i++) {
                        int val = q.poll();
                        for (int x = 0; x < isConnected[val].length; x++) {
                            if (isConnected[val][x] == 1) {
                                if (visited[x] == 0) {
                                    visited[x] = 1;
                                    q.add(x);
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    // public static int bfs(int[][] isConnected, int start, int target) {
    // int visited[] = new int[isConnected.length];
    // visited[start] = 1;

    // Queue<Integer> q = new LinkedList<>();
    // q.add(start);

    // while (!q.isEmpty()) {
    // int len = q.size();
    // for (int i = 0; i < len; i++) {
    // int val = q.poll();
    // for (int x = 0; x < isConnected[val].length; x++) {
    // if (isConnected[val][x] == 1) {
    // if (x == target) {
    // return 1;
    // }
    // if (visited[x] == 0) {
    // visited[x] = 1;
    // q.add(x);
    // }
    // }
    // }
    // }
    // }
    // return -1;
    // }
}
