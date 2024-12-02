package LeetOct;

import java.util.*;
// 2577. Minimum Time to Visit a Cell In a Grid

public class MinimumTimeToVisitACellInAGrid {
    public static void main(String[] args) {
        int grid[][] = { { 0, 1, 3, 2 }, { 5, 1, 2, 5 }, { 4, 3, 8, 6 } };
        System.out.println(minimumTime(grid));
    }

    public static int minimumTime(int[][] grid) {
        if(grid[0][1] > 1 && grid[1][0] > 1) return -1;
        
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((x, y) -> x.get(2) - y.get(2));
        List<Integer> temp = new LinkedList<>() {
            {
                add(0); // x axis
                add(0); // y axis
                add(0); // time
            }
        };

        int m = grid.length;
        int n = grid[0].length;

        int timeToReach[] = new int[m * n];
        timeToReach[0] = 0;

        while (!pq.isEmpty()) {
            List<Integer> val = pq.poll();
            int xAxis = val.get(0);
            int yAxis = val.get(1);
            int time = val.get(2);

            if (xAxis - 1 >= 0) {
                int tempxAxis = xAxis - 1;
                int tempyAxis = yAxis;
            }

            if (xAxis + 1 < m) {
                int tempxAxis = xAxis + 1;
                int tempyAxis = yAxis;
            }

            if (yAxis - 1 >= 0) {
                int tempxAxis = xAxis;
                int tempyAxis = yAxis - 1;
            }

            if (yAxis + 1 < n) {
                int tempxAxis = xAxis;
                int tempyAxis = yAxis + 1;
            }
        }

        return 0;
    }
}
