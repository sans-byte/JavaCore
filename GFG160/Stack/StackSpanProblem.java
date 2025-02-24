package GFG160.Stack;

import java.util.*;

public class StackSpanProblem {
    public static void main(String[] args) {
        int arr[] = { 10, 4, 5, 90, 120, 80 };
        System.out.println(calculateSpan(arr));
    }

    public static ArrayList<Integer> calculateSpan(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> temp = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                temp.add(stack.pop());
                count++;
            }
            res.add(count);
            stack.add(arr[i]);
            while (!temp.isEmpty())
                stack.add(temp.pop());
        }
        return res;
    }
}
