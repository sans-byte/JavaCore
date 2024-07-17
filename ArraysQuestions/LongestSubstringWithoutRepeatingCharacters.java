package ArraysQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "ohomm";

        System.out.println(lengthOfLongestSubstring(s));
    }

    static int lengthOfLongestSubstring(String s) {
        int length = 0;
        int l = 0;
        int r = 0;
        // Set<Character> set = new LinkedHashSet<>();

        // while (l < s.length() && r < s.length()) {
        // while (set.contains(s.charAt(r))) {
        // set.remove(set.iterator().next()); // Here we are traversing again from back
        // so time complexity > O(N)
        // }
        // set.add(s.charAt(r));
        // System.out.println(set);
        // r++;
        // length = Math.max(length, set.size());
        // }

        // Best solution where time complexity will exactly be O(N);
        Map<Character, Integer> map = new HashMap<>();
        while (l < s.length() && r < s.length()) {
            if (map.containsKey(s.charAt(r)) && l <= map.get(s.charAt(r))) {
                l = map.get(s.charAt(r)) + 1;
            }
            map.put(s.charAt(r), r);
            System.out.println(map);
            System.out.println(r);
            System.out.println(l);
            length = Math.max(length, r - l + 1);
            r++;
        }

        return length;
    }
}
