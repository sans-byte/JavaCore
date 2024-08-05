package Recursion;

import java.util.Stack;

public class SortAStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(11);
        s.push(2);
        s.push(32);
        s.push(3);
        s.push(41);
        System.out.println(s);
        sortStack(s);
        System.out.println(s);
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

    static void sortedInsert(Stack<Integer> s, int x) {
        if (s.empty() || s.peek() > x){
            s.push(x);
            return;
        }
        int top = s.pop();
        sortedInsert(s, x);
        s.push(top);
        return;
    }

    static void sortStack(Stack<Integer> s) {
        if (s.empty()) {
            return;
        }
        int x = s.pop();
        sortStack(s);
        sortedInsert(s, x);
        return;
    }
}
