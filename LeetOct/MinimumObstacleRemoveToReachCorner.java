package LeetOct;

import java.util.*;

public class MinimumObstacleRemoveToReachCorner {
    public static void main(String[] args) {
        int grid[][] = { { 0, 1, 0, 0, 0 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 1, 0 } };
        int m = grid.length;
        int n = grid[0].length;
        int distance[] = new int[m * n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.add(new int[] { 0, 0, 0 });

        while (!pq.isEmpty()) {
            int[] val = pq.poll();
            int eleX = val[0];
            int eleY = val[1];
            int dis = val[2];

            if (eleX - 1 >= 0) {
                int tempEleX = eleX - 1;
                int tempEleY = eleY;
                int currDis = dis + grid[tempEleX][tempEleY];
                if (currDis < distance[n * tempEleX + tempEleY]) {
                    distance[n * tempEleX + tempEleY] = currDis;
                    pq.add(new int[] { tempEleX, tempEleY, currDis });
                }
            }

            if (eleX + 1 < m) {
                int tempEleX = eleX + 1;
                int tempEleY = eleY;
                int currDis = dis + grid[tempEleX][tempEleY];
                if (currDis < distance[n * tempEleX + tempEleY]) {
                    distance[n * tempEleX + tempEleY] = currDis;
                    pq.add(new int[] { tempEleX, tempEleY, currDis });
                }
            }

            if (eleY - 1 >= 0) {
                int tempEleX = eleX;
                int tempEleY = eleY - 1;
                int currDis = dis + grid[tempEleX][tempEleY];
                if (currDis < distance[n * tempEleX + tempEleY]) {
                    distance[n * tempEleX + tempEleY] = currDis;
                    pq.add(new int[] { tempEleX, tempEleY, currDis });
                }
            }

            if (eleY + 1 < n) {
                int tempEleX = eleX;
                int tempEleY = eleY + 1;
                int currDis = dis + grid[tempEleX][tempEleY];
                if (currDis < distance[n * tempEleX + tempEleY]) {
                    distance[n * tempEleX + tempEleY] = currDis;
                    pq.add(new int[] { tempEleX, tempEleY, currDis });
                }
            }
        }
        System.out.println(Arrays.toString(distance));
    }
}
