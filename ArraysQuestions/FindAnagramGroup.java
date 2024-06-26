package ArraysQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/group-anagrams/

public class FindAnagramGroup {
    public static void main(String[] args) {
        String[] strs = { "ddddddddddg", "dgggggggggg" };
        // System.out.println(groupAnagrams(strs));

        System.out.println(groupAnagrams(strs));

        // Output: [["bat"],["nat","tan"],["ate","eat","tea"]] //order can be anything

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();

        for (String word : strs) {
            char[] l = word.toCharArray();
            Arrays.sort(l);
            System.out.println(l);
            String sortedWord = new String(l);

            if (!m.containsKey(sortedWord)) {
                m.put(sortedWord, new ArrayList<>());
            }

            m.get(sortedWord).add(word);
        }
        return new ArrayList<>(m.values());
    }
}
