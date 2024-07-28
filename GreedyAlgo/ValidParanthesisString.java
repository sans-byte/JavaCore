package GreedyAlgo;

import java.util.Stack;

// https://leetcode.com/problems/valid-parenthesis-string/

public class ValidParanthesisString {
    public static void main(String[] args) {
        // String s = "(((((()*)(*)*))())())(()())())))((**)))))(()())()";
        String s = "))****))";

        System.out.println(checkValidString(s));
    }

    static boolean checkValidString(String s) {
        int min = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                min++;
                max++;
            } else if (s.charAt(i) == ')') {
                min--;
                max--;
            } else {
                min--;
                max++;
            }

            if (min < 0)
                min = 0;
            if (max < 0)
                return false;
        }

        if (min == 0)
            return true;

        return false;
    }
}
