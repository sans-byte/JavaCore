import java.util.*;

public class UniqueLengthPalindromicSubsequences {
    public static void main(String[] args) {
        String s = "aabca";
        System.out.println(countPalindromicSubsequence(s));
        System.out.println(countPalindromicSubsequence1(s));
    }

    public static void helper(String s, StringBuilder temp, int i, Set<String> set) {

        if (temp.length() == 3 && temp.charAt(0) == temp.charAt(2)) {
            set.add(temp.toString());
            return;
        }

        if (temp.length() > 3) {
            return;
        }

        if (i >= s.length()) {
            return;
        }

        temp.append(s.charAt(i));
        helper(s, new StringBuilder(temp), i + 1, set);
        temp.deleteCharAt(temp.length() - 1);
        helper(s, new StringBuilder(temp), i + 1, set);
        return;
    }

    public static int countPalindromicSubsequence(String s) {
        Set<String> set = new HashSet<>();
        helper(s, new StringBuilder(), 0, set);
        return set.size();
    }

    public static int countPalindromicSubsequence1(String s) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            int x = 0;
            int y = s.length() - 1;
            while (x < s.length() && s.charAt(x) != c) {
                x++;
            }

            while (y >= 0 && s.charAt(y) != c) {
                y--;
            }

            if (x == y)
                continue;

            for (int j = x + 1; j < y; j++) {
                String temp = "" + s.charAt(x) + s.charAt(j) + s.charAt(y);
                set.add(temp);
            }
        }

        return set.size();
    }

    public static int countPalindromicSubsequenceBetter(String s) {
        Set<Character> charSet = new HashSet<>();
        int count = 0;
        for(int i=0;i<s.length();i++) charSet.add(s.charAt(i));
        for(char c:charSet){
            int x = 0;
            int y = s.length() - 1;
            while (x < s.length() && s.charAt(x) != c) {
                x++;
            }

            while (y > x && s.charAt(y) != c) {
                y--;
            }

            Set<Character> set = new HashSet<>();
            for (int j = x + 1; j < y; j++) {
               set.add(s.charAt(j));
            }
            count += set.size();
        }
        return count;
    }
}