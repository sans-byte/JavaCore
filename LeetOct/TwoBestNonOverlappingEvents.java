package LeetOct;

// https://www.youtube.com/watch?v=Nhvf_hmDa6I

import java.util.*;

public class TwoBestNonOverlappingEvents {
    public static void main(String[] args) {
        // int events[][] = { { 1, 3, 2 }, { 4, 5, 2 }, { 2, 4, 3 } };
        int events[][] = { { 1, 1, 5 }, { 3, 4, 1 }, { 2, 4, 5 }, { 2, 5, 3 }, { 2, 3, 4 } };
        // System.out.println(maxTwoEvents(events));

        System.out.println(maxTwoEvents1(events));
    }

    // public static int maxTwoEvents(int[][] events) {
    // PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[1],
    // y[1]));
    // Arrays.sort(events, (x, y) -> Integer.compare(x[0], y[0]));

    // int maxValue = 0, ans = 0;
    // for (int i = 0; i < events.length; i++) {
    // while (!pq.isEmpty() && pq.peek()[1] < events[i][0]) {
    // maxValue = Math.max(maxValue, pq.peek()[2]);
    // pq.poll();
    // }

    // ans = Math.max(ans, maxValue + events[i][2]);
    // pq.add(events[i]);
    // }
    // return ans;
    // }

    // With second approach
    // DP and recursion
    // Better approach because it can solve the followup question of what if the
    // number of jobs given are K

    // TODO : Good question must visit again

    private static int upperBound(int arr[], int key) {
        int mid, N = arr.length;
        int low = 0;
        int high = N;
        while (low < high && low != N) {
            mid = low + ((high - low) / 2);
            if (key >= arr[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private static int getMaxEvents(int idx, int attendedEvents, int[][] events, int[][] dp, int[] startTimes) {
        if (idx >= events.length || attendedEvents == 2) { // Now if we are asked for k values we just need to change here
            return 0;
        }

        if (dp[idx][attendedEvents] != -1) {
            return dp[idx][attendedEvents];
        }

        int newIndex = upperBound(startTimes, events[idx][1]);
        if (newIndex < 0) {
            newIndex = -(newIndex + 1);
        }
        int val1 = events[idx][2] + getMaxEvents(newIndex, attendedEvents + 1, events, dp, startTimes);

        int val2 = getMaxEvents(idx + 1, attendedEvents, events, dp, startTimes);

        return dp[idx][attendedEvents] = Math.max(val1, val2);
    }

    public static int maxTwoEvents1(int[][] events) {
        Arrays.sort(events, (x, y) -> Integer.compare(x[0], y[0]));
        int dp[][] = new int[events.length][2]; // if we are asked for k values we have to change it here
        for (int[] i : dp)
            Arrays.fill(i, -1);
        int startTimes[] = new int[events.length];
        for (int i = 0; i < events.length; i++) {
            startTimes[i] = events[i][0];
        }

        System.out.println(Arrays.toString(startTimes));
        return getMaxEvents(0, 0, events, dp, startTimes);
    }
}
