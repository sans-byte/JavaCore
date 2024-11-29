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

        int x = 0;
        int y = 0;

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> a.get(2) - b.get(2));
        List<Integer> temp = new ArrayList<>() {
            {
                add(x);
                add(y);
                add(grid[x][y]);
            }
        };

        pq.add(temp);

        System.out.println(pq);

        while (!pq.isEmpty()) {
            List<Integer> val = pq.poll();
            System.out.println("hell");
            int eleX = val.get(0);
            int eleY = val.get(1);
            int dis = val.get(2);

            if (eleX - 1 >= 0) {
                int tempEleX = eleX - 1;
                int tempEleY = eleY;
                int currDis = dis + grid[tempEleX][tempEleY];
                if (currDis < distance[n * tempEleX + tempEleY]) {
                    distance[n * tempEleX + tempEleY] = currDis;
                    List<Integer> temp1 = new ArrayList<>();
                    temp1.add(tempEleX);
                    temp1.add(tempEleY);
                    temp1.add(currDis);
                    pq.add(temp1);
                }
            }

            if (eleX + 1 < m) {
                int tempEleX = eleX + 1;
                int tempEleY = eleY;
                int currDis = dis + grid[tempEleX][tempEleY];
                if (currDis < distance[n * tempEleX + tempEleY]) {
                    distance[n * tempEleX + tempEleY] = currDis;
                    List<Integer> temp1 = new ArrayList<>();
                    temp1.add(tempEleX);
                    temp1.add(tempEleY);
                    temp1.add(currDis);
                    pq.add(temp1);
                }
            }

            if (eleY - 1 >= 0) {
                int tempEleX = eleX;
                int tempEleY = eleY - 1;
                int currDis = dis + grid[tempEleX][tempEleY];
                if (currDis < distance[n * tempEleX + tempEleY]) {
                    distance[n * tempEleX + tempEleY] = currDis;
                    List<Integer> temp1 = new ArrayList<>();
                    temp1.add(tempEleX);
                    temp1.add(tempEleY);
                    temp1.add(currDis);
                    pq.add(temp1);

                }
            }

            if (eleY + 1 < n) {
                int tempEleX = eleX;
                int tempEleY = eleY + 1;
                int currDis = dis + grid[tempEleX][tempEleY];
                if (currDis < distance[n * tempEleX + tempEleY]) {
                    distance[n * tempEleX + tempEleY] = currDis;
                    List<Integer> temp1 = new ArrayList<>();
                    temp1.add(tempEleX);
                    temp1.add(tempEleY);
                    temp1.add(currDis);
                    pq.add(temp1);
                }
            }
        }
        System.out.println(Arrays.toString(distance));
    }
}
