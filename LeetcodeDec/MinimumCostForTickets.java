import java.util.Arrays;

public class MinimumCostForTickets {

    public static void main(String[] args) {
        int days[] = { 1, 4, 6, 7, 8, 20 }, costs[] = { 2, 7, 15 };
        System.out.println(mincostTickets(days, costs));
    }

    public static int upperBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static int helper(int[] days, int[] costs, int i, int[] dp) {
        if (i >= days.length) {
            return 0;
        }

        if (dp[i] != -1)
            return dp[i];

        int option1 = costs[0] + helper(days, costs, i + 1, dp);
        int option2 = costs[1] + helper(days, costs, upperBound(days, days[i] + 6), dp);
        int option3 = costs[2] + helper(days, costs, upperBound(days, days[i] + 29), dp);

        dp[i] = Math.min(option1, Math.min(option2, option3));
        return dp[i];
    }

    public static int mincostTickets(int[] days, int[] costs) {
        int res[] = new int[1];
        int dp[] = new int[days.length + 1];
        Arrays.fill(dp, -1);
        res[0] = Integer.MAX_VALUE;
        return helper(days, costs, 0, dp);
    }
}
