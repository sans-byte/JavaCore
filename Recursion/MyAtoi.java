package Recursion;

// https://leetcode.com/problems/string-to-integer-atoi/description/

public class MyAtoi {
    public static void main(String[] args) {
        String s = "-91283472332";
        long res = 0;
        s = s.trim();
        if (s.charAt(0) == '-') {
            System.out.println(-1 * printNumber(s, res, 1));
        } else {
            System.out.println(printNumber(s, res, 0));
        }
    }


    // Giving wrong answers for edge cases
    static long printNumber(String s, long res, int i) {
        if (i >= s.length())
            return res;
        char x = s.charAt(i);
        int c = (int) x - 48;
        if (c < 0 || c > 9)
            return res;
        return printNumber(s, res * 10 + c, i + 1);
    }
}
