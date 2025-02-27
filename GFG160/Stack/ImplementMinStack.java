package GFG160.Stack;

import java.util.*;


public class ImplementMinStack {
    Stack<int[]> stack = new Stack<>();

    public ImplementMinStack() {

    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.add(new int[] { val, val });
        } else {
            stack.add(new int[] { val, Math.min(stack.peek()[1], val) });
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty())
            return -1;
        return stack.peek()[0];
    }

    public int getMin() {
        if (stack.isEmpty())
            return -1;
        return stack.peek()[1];
    }

    public static void main(String[] args) {

    }

}

// first apporach with pair

// public class ImplementMinStack {
//     Stack<int[]> stack = new Stack<>();

//     public ImplementMinStack() {

//     }

//     public void push(int val) {
//         if (stack.isEmpty()) {
//             stack.add(new int[] { val, val });
//         } else {
//             stack.add(new int[] { val, Math.min(stack.peek()[1], val) });
//         }
//     }

//     public void pop() {
//         stack.pop();
//     }

//     public int top() {
//         if (stack.isEmpty())
//             return -1;
//         return stack.peek()[0];
//     }

//     public int getMin() {
//         if (stack.isEmpty())
//             return -1;
//         return stack.peek()[1];
//     }

//     public static void main(String[] args) {

//     }

// }
