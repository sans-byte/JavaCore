package GreedyAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

public class NMeetingsInOneRoom {
    public static void main(String[] args) {
        // int start[] = { 1, 3, 0, 5, 8, 5 };
        // int end[] = { 2, 4, 6, 7, 9, 9 };
        int start[] = { 10, 12, 20 };
        int end[] = { 20, 25, 30 };
        // Question can ask for max number of meetings, which all meetings are
        // preformed.

        System.out.println(maxMeetings(start, end));
    }

    static int maxMeetings(int[] start, int[] end) {

        // Intution here is to be greedy for the end time and pick up those whose end
        // time is less
        int[][] combined = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            int[] arr = new int[3];
            arr[0] = start[i];
            arr[1] = end[i];
            arr[2] = i;
            combined[i] = arr;
        }
        int count = 0;

        Arrays.sort(combined, new Comparator<int[]>() {
            public int compare(int[] a, int b[]) {
                return Integer.compare(a[1], b[1]);
            }
        });

        int endTime = Integer.MIN_VALUE;
        List<Integer> meetings = new ArrayList<>();

        for (int i = 0; i < combined.length; i++) {
            if (combined[i][0] > endTime) {
                count++;
                endTime = combined[i][1];
                meetings.add(combined[i][2]);
            }
        }

        return count;
    }
}
