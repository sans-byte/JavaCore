package Hard;

import java.util.*;

//TODO : revisit brushup DP
// DP question

public class NumberofWaystoFormaTargetStringGivenaDictionary {
    public static void main(String[] args) {
        String words[] = { "acca", "bbbb", "caca" }, target = "aba";
        System.out.println(numWays(words, target));
    }

    public static int numWays(String[] words, String target) {
        int n = words[0].length();
        int m = target.length();
        int dp[] = new int[m + 1];
        dp[0] = 1;
        int mod = 1000000007;

        int count[][] = new int[n][26];
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                count[i][index]++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                dp[j + 1] += (int) ((long) (dp[j] * count[i][target.charAt(j) - 'a'])) % mod;
                dp[j + 1] %= mod;
            }
        }
        return dp[m];
    }
}
