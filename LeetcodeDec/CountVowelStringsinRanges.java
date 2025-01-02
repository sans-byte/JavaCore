import java.util.*;

public class CountVowelStringsinRanges {
    public static void main(String[] args) {
        String[] words = { "aba", "bcb", "ece", "aa", "e" };
        int queries[][] = { { 0, 2 }, { 1, 4 }, { 1, 1 } };
        System.out.println(Arrays.toString(vowelStrings(words, queries)));
    }

    public static int[] vowelStrings(String[] words, int[][] queries) {
        int arr[] = new int[words.length];
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        int prefix = 0;
        for (int i = 0; i < words.length; i++) {
            int n = words[i].length();
            if (set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(n - 1))) {
                prefix++;
            }
            arr[i] = prefix;
        }

        int res[] = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];
            int val = arr[e];
            if (s > 0) {
                val -= arr[s - 1];
            }
            res[i] = val;
        }

        return res;
    }
}
