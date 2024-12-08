package LeetOct;

import java.lang.reflect.Array;

// https://www.youtube.com/watch?v=Nhvf_hmDa6I

import java.util.*;

public class TwoBestNonOverlappingEvents {
    public static void main(String[] args) {
        int events[][] = { { 1, 3, 2 }, { 4, 5, 2 }, { 2, 4, 3 } };
        System.out.println(maxTwoEvents(events));
    }

    public static int maxTwoEvents(int[][] events) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[1], y[1]));
        Arrays.sort(events, (x, y) -> Integer.compare(x[0], y[0]));

        int maxValue = 0, ans = 0;
        for (int i = 0; i < events.length; i++) {
            while (!pq.isEmpty() && pq.peek()[1] < events[i][0]) {
                maxValue = Math.max(maxValue, pq.peek()[2]);
                pq.poll();
            }

            ans = Math.max(ans, maxValue + events[i][2]);
            pq.add(events[i]);
        }
        return ans;
    }
}
