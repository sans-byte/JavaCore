package LeetcodeDec;

import java.util.*;

public class MaximumAveragePassRatio {
    public static void main(String[] args) {
        int classes[][] = { { 2, 4 }, { 3, 9 }, { 4, 5 }, { 2, 10 } }, extraStudents = 4;
        System.out.println(maxAverageRatio(classes, extraStudents));
    }

    public static double calculateDelta(int x, int y) {
        return (double) (x + 1) / (y + 1) - (double) x / y;
    }

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        double res = 0;
        PriorityQueue<double[]> pq = new PriorityQueue<>((x, y) -> Double.compare(y[0], x[0]));
        for (int i = 0; i < classes.length; i++) {
            double gain = calculateDelta(classes[i][0], classes[i][1]);
            pq.add(new double[] { gain, classes[i][0], classes[i][1] });
        }

        while (extraStudents > 0) {
            double maxArr[] = pq.poll();
            double passStudents = maxArr[1];
            double totalStudents = maxArr[2];

            pq.add(new double[] { calculateDelta((int) passStudents + 1, (int) totalStudents + 1), passStudents + 1,
                    totalStudents + 1 });
            extraStudents--;
        }

        double avgPassTotal = 0;
        while (!pq.isEmpty()) {
            double arr[] = pq.poll();
            avgPassTotal += arr[1] / arr[2];
        }

        res = avgPassTotal / classes.length;
        return res;
    }
}
