import java.util.Arrays;

public class CountWaysToBuildGoodString {
    static int mod = 1000000007;

    public static void main(String[] args) {
        int low = 500, high = 500, zero = 5, one = 2;
        System.out.println(countGoodStrings(low, high, zero, one));
    }

    public static int helper(int len, int low, int high, int one, int zero, int dp[]) {
        int count = 0;

        if (len >= low && len <= high) {
            count += 1;
        }

        if (len > high)
            return 0;

        if (dp[len] != -1)
            return dp[len];

        count += helper(len + zero, low, high, zero, one, dp)
                + helper(len + one, low, high, zero, one, dp);

        dp[len] = count % mod;

        return dp[len];
    }

    public static int countGoodStrings(int low, int high, int zero, int one) {
        int dp[] = new int[high + 1];
        Arrays.fill(dp, -1);
        int count = helper(0, low, high, one, zero, dp);
        return (count % mod);
    }
}
