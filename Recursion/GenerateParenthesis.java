package Recursion;

// https://leetcode.com/problems/generate-parentheses/

public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 3;
        generateParanthesis(n, 0, 0, "");
    }

    static void generateParanthesis(int n, int l, int r, String str) {
        if (l == n && r == n) {
            System.out.println(str);
            return;
        }
        if (l == n) {
            generateParanthesis(n, l, r + 1, str + ")");
        } else if (l > r) {
            generateParanthesis(n, l + 1, r, str + "(");
            generateParanthesis(n, l, r + 1, str + ")");
        } else if (l == r) {
            generateParanthesis(n, l + 1, r, str + "(");
        }
    }
}
