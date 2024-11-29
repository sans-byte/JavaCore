package LeetOct;

import java.util.*;

// if given 3*3 matrix

public class MinimumObstacleRemoveToReachCornerIfGiven {
    public static void main(String[] args) {
        int grid[][] = { { 0, 1, 1 }, { 1, 1, 0 }, { 1, 1, 0 } };
        System.out.println(minimumObstacles(grid));
    }

    public static int minimumObstacles(int[][] grid) {
        int combined[] = new int[9];
        int index = 0;
        for (int[] i : grid) {
            for (int j : i) {
                combined[index] = j;
                index++;
            }
        }

        int adjList[][] = { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4, 6 }, { 1, 3, 5, 7 }, { 2, 4, 8 }, { 3, 7 },
                { 4, 6, 8 }, { 5, 7 } };

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((x, y) -> x.get(1) - y.get(1));
        List<Integer> temp = new ArrayList<>() {
            {
                add(0);
                add(0);
            }
        };
        pq.add(temp);

        int distance[] = new int[9];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        while (!pq.isEmpty()) {
            List<Integer> val = pq.poll();
            int ele = val.get(0);
            int dis = val.get(1);

            for (int it : adjList[ele]) {
                int currEle = it;
                int currDis = combined[currEle] + dis;

                if (currDis < distance[currEle]) {
                    List<Integer> temp1 = new ArrayList<>();
                    temp1.add(currEle);
                    temp1.add(currDis);
                    pq.add(temp1);
                    distance[currEle] = currDis;
                }
            }
        }
        System.out.println(Arrays.toString(distance));
        int res = distance[8];
        return res;
    }
}
