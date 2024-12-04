package GFG160;

import java.util.Arrays;

// Min Chars to Add for Palindrome
// It is given in the question that we can only add characters at the start

public class MinimumCharactersToAddToMakeAPalindrome {
    public static void main(String[] args) {
        String s = "aacecaaaa";
        System.out.println(minChar(s));
    }

    public static int minChar(String s) {
        StringBuilder tempS = new StringBuilder(s);
        tempS.reverse();
        String tempString = s + "$" + tempS.toString();
        int lps[] = new int[tempString.length()];
        createLPS(tempString, lps);
        return s.length() - lps[lps.length - 1];
    }

    static void createLPS(String s, int[] lps) {
        int pre = 0;
        int suf = 1;

        while (suf < s.length()) {
            if (s.charAt(suf) == s.charAt(pre)) {
                lps[suf] = pre + 1;
                pre++;
                suf++;
            } else {
                if (pre == 0) {
                    lps[suf] = 0;
                    suf++;
                } else {
                    pre = lps[pre - 1];
                }
            }
        }
    }
}
