package LeetcodeJan;

import java.util.*;

public class CheckifaParenthesesStringCanBeValid {
    public static void main(String[] args) {
        // String s = "))()))", locked = "010100";
        String s = "((()(()()))()((()()))))(", locked = "101111001001010011101000";
        System.out.println(canBeValid(s, locked));
    }

    public static boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0)
            return false;

        Stack<char[]> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (locked.charAt(i) == '0') {
                    if (!stack.isEmpty() && (stack.peek()[1] == '0' || stack.peek()[0] == '(')) {
                        stack.pop();
                    } else {
                        stack.add(new char[] { s.charAt(i), locked.charAt(i) });
                    }
                } else {
                    stack.add(new char[] { s.charAt(i), locked.charAt(i) });
                }
            } else {
                if (!stack.isEmpty() && (stack.peek()[1] == '0' || stack.peek()[0] == '(')) {
                    stack.pop();
                } else {
                    stack.add(new char[] { s.charAt(i), locked.charAt(i) });
                }
            }
        }
        for (char[] i : stack) {
            System.out.println(Arrays.toString(i));
        }
        return stack.isEmpty();
    }
}
