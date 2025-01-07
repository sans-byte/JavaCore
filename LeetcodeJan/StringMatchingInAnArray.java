package LeetcodeJan;

import java.util.*;

public class StringMatchingInAnArray {
    public static void main(String[] args) {
        String words[] = { "mass", "as", "hero", "superhero" };
        System.out.println(stringMatching(words));
    }

    // simple brute force approach
    public static List<String> stringMatching(String[] words) {
        Set<String> res = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[i].length() > words[j].length() && words[i].contains(words[j])) {
                    res.add(words[j]);
                }
            }
        }
        return new ArrayList<>(res);
    }
}
