package LeetcodeMar;

import java.util.*;

public class CountDaysWithoutMeetings {
    public static void main(String[] args) {

        // int days = 10, meetings[][] = { { 5, 7 }, { 1, 3 }, { 9, 10 } };
        // int days = 10, meetings[][] = { { 2, 4 }, { 1, 3 } };
        // int days = 8, meetings[][] = { { 3, 4 }, { 4, 8 }, { 2, 5 }, { 3, 8 } };
        int days = 65, meetings[][] = {
                { 37, 40 }, { 16, 19 }, { 20, 25 }, { 3, 55 }, { 16, 38 },
                { 2, 44 }, { 54, 58 }, { 14, 24 }, { 13, 21 }
        };

        System.out.println(countDays(days, meetings));
    }

    public static int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (x, y) -> Integer.compare(x[0], y[0]));
        // for (int i[] : meetings) {
        // System.out.println(Arrays.toString(i));
        // }
        List<int[]> list = new ArrayList<>();
        // for (int i = 0; i < meetings.length; i++) {
        // list.add(new int[] { meetings[i][0], meetings[i][1] });
        // }
        list.add(new int[] { meetings[0][0], meetings[0][1] });
        int lastValue = meetings[0][1];
        for (int i = 1; i < meetings.length; i++) {
            if (lastValue >= meetings[i][1]) {
                continue;
            } else if (lastValue >= meetings[i][0] && lastValue < meetings[i][1]) {
                list.get(list.size() - 1)[1] = meetings[i][1];
            } else {
                list.add(new int[] { meetings[i][0], meetings[i][1] });
            }
            lastValue = meetings[i][1];
        }
        for (int i[] : list) {
            System.out.println(Arrays.toString(i));
        }
        int sum = 0;
        for (int i = 1; i < list.size(); i++) {
            sum += list.get(i)[0] - list.get(i - 1)[1] - 1;
        }
        sum += (list.get(0)[0] - 1) + (days - list.get(list.size() - 1)[1]);
        return sum;
    }
}
