package LeetOct;

import java.util.*;

public class MakeStringASubsequenceUsingCyclicIncrements {
    public static void main(String[] args) {
        String str1 = "abc", str2 = "ad";
        System.out.println(canMakeSubsequence(str1, str2));
    }

    public static void createAllSequence(String str, int i, List<String> list) {
        if (i >= str.length())
            return;

        for (int idx = i; idx < str.length(); idx++) {
            char temp = (char) ('a' + (str.charAt(idx) - 'a' + 1) % 26);
            String tempString = str.substring(0, idx) + temp + str.substring(idx + 1, str.length());
            list.add(tempString);
            createAllSequence(tempString, idx + 1, list);
        }
    }

    public static boolean canMakeSubsequence(String str1, String str2) {
        List<String> list = new ArrayList<>();
        list.add(str1);
        createAllSequence(str1, 0, list);
        for (int i = 0; i < list.size(); i++) {
            int idx = 0;
            for (int j = 0; j < list.get(i).length(); j++) {
                if (list.get(i).charAt(j) == str2.charAt(idx)) {
                    idx++;
                }
                if (idx == str2.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
