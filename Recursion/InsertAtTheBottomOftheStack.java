package Recursion;

import java.util.Stack;

public class InsertAtTheBottomOftheStack {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(10);
        s.push(20);
        s.push(25);
        s.push(50);

        int x = 1;

        System.out.println(insertAtBottom(s, x));
    }

    static Stack insertAtBottom(Stack<Integer> s, int x) {
        if (s.empty()) {
            s.push(x);
            return s;
        }
        int value = s.pop();
        insertAtBottom(s, x);
        s.push(value);
        return s;
    }
}
