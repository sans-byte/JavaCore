package GFG160.Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 4 };
        System.out.println(nextLargerElement(arr));
    }

    public static ArrayList<Integer> nextLargerElement(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i])
                stack.pop();
            if (stack.isEmpty())
                res.add(-1);
            else
                res.add(stack.peek());
            stack.add(arr[i]);
        }
        Collections.reverse(res);
        return res;
    }
}
