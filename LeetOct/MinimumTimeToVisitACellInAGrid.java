package LeetOct;

import java.util.*;
// 2577. Minimum Time to Visit a Cell In a Grid

public class MinimumTimeToVisitACellInAGrid {
    public static void main(String[] args) {
        int grid[][] = { { 0, 1, 3, 2 }, { 5, 1, 2, 5 }, { 4, 3, 8, 6 } };
        System.out.println(minimumTime(grid));
    }

    public static int minimumTime(int[][] grid) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((x,y) -> x.get(2) - y.get(2));
        List<Integer> temp = new LinkedList<>() {
            {
                add(0); // x axis
                add(0); // y axis
                add(0); // time
            }
        };

        int m = grid.length;
        int n = grid[0].length;

        int time[] = new int[m * n];
        time[0] = 0;

        while (!pq.isEmpty()) {
            
        }

        return 0;
    }
}
