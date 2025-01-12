package LeetcodeJan;

import java.util.*;

public class CheckifaParenthesesStringCanBeValid {
    public static void main(String[] args) {
        // String s = "))()))", locked = "010100";
        String s = "((()(()()))()((()()))))(", locked = "101111001001010011101000";
        System.out.println(canBeValid(s, locked));
        System.out.println(canBeValid1(s, locked));
    }

    public static boolean canBeValid(String s, String locked) {
        int stringLength = s.length();
        if (stringLength % 2 == 1) {
            return false;
        }

        Stack<Integer> openIndices = new Stack<>();
        Stack<Integer> unlockedIndices = new Stack<>();

        // Traverse the string
        for (int i = 0; i < stringLength; i++) {
            if (locked.charAt(i) == '0') {
                unlockedIndices.push(i);
            } else if (s.charAt(i) == '(') {
                openIndices.push(i);
            } else if (s.charAt(i) == ')') {
                if (!openIndices.isEmpty()) {
                    openIndices.pop();
                } else if (!unlockedIndices.isEmpty()) {
                    unlockedIndices.pop();
                } else {
                    return false;
                }
            }
        }

        // Match remaining open parentheses
        while (!openIndices.isEmpty() && !unlockedIndices.isEmpty() &&
                openIndices.peek() < unlockedIndices.peek()) {
            openIndices.pop();
            unlockedIndices.pop();
        }

        // Final check
        if (openIndices.isEmpty() && !unlockedIndices.isEmpty()) {
            return unlockedIndices.size() % 2 == 0;
        }

        return openIndices.isEmpty();
    }

    public static boolean canBeValid1(String s, String locked) {
        int unlocked = 0;
        int openBrackets = 0;

        // left to right pass
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0') {
                unlocked++;
            } else if (s.charAt(i) == '(') {
                openBrackets++;
            } else { // s.charAt(i) == ')'
                if (openBrackets > 0) {
                    openBrackets--;
                } else if (unlocked > 0) {
                    unlocked--;
                } else {
                    return false;
                }
            }
        }

        unlocked = 0;
        openBrackets = 0;
        // right to left pass
        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                unlocked++;
            } else if (s.charAt(i) == ')') {
                openBrackets++;
            } else { // s.charAt(i) == '('
                if (openBrackets > 0) {
                    openBrackets--;
                } else if (unlocked > 0) {
                    unlocked--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
