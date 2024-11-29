package Graphs;

import java.util.*;

class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        List<List<iPair>> l = new ArrayList<>();
        int adj[][][] = { { { 1, 1 }, { 2, 6 } }, { { 2, 3 }, { 0, 1 } }, { { 1, 3 }, { 0, 6 } } };
        for (int i = 0; i < adj.length; i++) {
            List<iPair> temp = new ArrayList<>();
            for (int j = 0; j < adj[i].length; j++) {
                iPair tempP = new iPair(adj[i][j][0], adj[i][j][1]);
                temp.add(tempP);
            }
            l.add(temp);
        }
        System.out.println(dijkstra(l, 2));
    }

    public static ArrayList<Integer> dijkstra(List<List<iPair>> adj, int src) {
        PriorityQueue<iPair> pq = new PriorityQueue<>((x, y) -> x.second - y.second);
        pq.add(new iPair(src, 0));

        int distance[] = new int[adj.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        while (!pq.isEmpty()) {
            iPair val = pq.poll();
            int ele = val.first;
            int dis = val.second;

            for (iPair x : adj.get(ele)) {
                int currele = x.first;
                int currdis = x.second + dis;

                if (currdis < distance[currele]) {
                    distance[currele] = currdis;
                    pq.add(new iPair(currele, currdis));
                }
            }
        }
        System.out.println(Arrays.toString(distance));
        ArrayList<Integer> res = new ArrayList<>();
        for (int x : distance)
            res.add(x);
        return res;
    }
}
