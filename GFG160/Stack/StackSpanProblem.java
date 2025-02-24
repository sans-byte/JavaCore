package GFG160.Stack;

import java.util.*;

public class StackSpanProblem {
    public static void main(String[] args) {
        int arr[] = { 100, 80, 60, 70, 60, 75, 85 };
        System.out.println(calculateSpanMap(arr));
    }

    // public static ArrayList<Integer> calculateSpan(int[] arr) {
    // ArrayList<Integer> res = new ArrayList<>();
    // Stack<Integer> stack = new Stack<>();
    // Stack<Integer> temp = new Stack<>();

    // for (int i = 0; i < arr.length; i++) {
    // int count = 1;
    // while (!stack.isEmpty() && stack.peek() <= arr[i]) {
    // temp.add(stack.pop());
    // count++;
    // }
    // res.add(count);
    // while (!temp.isEmpty())
    // stack.add(temp.pop());
    // stack.add(arr[i]);
    // }
    // return res;
    // }

    public static ArrayList<Integer> calculateSpanMap(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 1);
        res.add(1);

        for (int i = 1; i < arr.length; i++) {
            int count = 1;
            int idx = i - 1;
            int val = arr[idx];
            while (val <= arr[i]) {
                int ct = map.get(val);
                count += ct;
                idx -= ct;
                if (idx < 0)
                    break;
                val = arr[idx];
            }
            map.put(arr[i], count);
            res.add(count);
        }
        return res;
    }
}

// public static Stack<Integer> stack = new Stack<>();
// public static Stack<Integer> temp = new Stack<>();

// public StockSpanner() {
// this.stack.clear();
// this.temp.clear();
// this.res.clear();
// }

// public int next(int price) {
// int count = 1;
// while (!stack.isEmpty() && stack.peek() < price) {
// temp.add(stack.pop());
// count++;
// }
// while (!temp.isEmpty())
// stack.add(temp.pop());
// stack.add(arr[i]);
// return count;
// }