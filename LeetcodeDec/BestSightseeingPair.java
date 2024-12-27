// 1014. Best Sightseeing Pair

public class BestSightseeingPair {
    public static void main(String[] args) {
        int values[] = { 8, 1, 5, 2, 6 };
        System.out.println(maxScoreSightseeingPair(values));
    }

    public static int maxScoreSightseeingPair(int[] values) {
        int currMax = values[0] - 1;
        int max = currMax;
        for (int i = 1; i < values.length; i++) {
            max = Math.max(max, values[i] + currMax);
            currMax = Math.max(currMax - 1, values[i] - 1);
        }
        return max;
    }
}
