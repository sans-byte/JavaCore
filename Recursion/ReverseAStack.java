package Recursion;

import java.util.Stack;

public class ReverseAStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(10);
        s.push(20);
        s.push(25);
        s.push(50);
        System.out.println(reverseStack(s));
    }

    static void insertAtBottom(Stack<Integer> s, int x) {
        if (s.empty()) {
            s.push(x);
            return;
        }
        int value = s.pop();
        insertAtBottom(s, x);
        s.push(value);
        return;
    }

    static Stack<Integer> reverseStack(Stack<Integer> s) {
        if (s.empty()) {
            return s;
        }
        int value = s.pop();
        reverseStack(s);
        insertAtBottom(s, value);
        return s;
    }
}
