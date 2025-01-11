package LeetcodeJan;

import java.util.*;

public class WordSubset {
    public static void main(String[] args) {
        String[] words1 = { "amazon", "apple", "facebook", "google", "leetcode" }, words2 = { "e", "o" };
        System.out.println(wordSubsets(words1, words2));
    }

    public static boolean helper(int[] arr, String str) {
        for (char x : str.toCharArray()) {
            int index = x - 'a';
            arr[index]--;
        }
        // System.out.println(Arrays.toString(arr));
        for (int i : arr) {
            if (i > 0)
                return false;
        }
        return true;
    }

    public static List<String> wordSubsets(String[] words1, String[] words2) {
        int arr1[] = new int[26];
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words2.length; i++) {
            int arr2[] = new int[26];
            for (char x : words2[i].toCharArray()) {
                int index = x - 'a';
                arr2[index]++;
                arr1[index] = Math.max(arr1[index], arr2[index]);
            }
        }
        for (int i = 0; i < words1.length; i++) {
            if (helper(arr1.clone(), words1[i])) {
                res.add(words1[i]);
            }
        }
        return res;
    }
}