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
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                temp.add(stack.pop());
                count++;
            }
            res.add(count);
            while (!temp.isEmpty())
                stack.add(temp.pop());
            stack.add(arr[i]);
        }
        return res;
    }
}


// public static Stack<Integer> stack = new Stack<>();
//     public static Stack<Integer> temp = new Stack<>();

//     public StockSpanner() {
//         this.stack.clear();
//         this.temp.clear();
//         this.res.clear();
//     }
    
//     public int next(int price) {
//         int count = 1;
//         while (!stack.isEmpty() && stack.peek() < price) {
//             temp.add(stack.pop());
//             count++;
//         }
//         while (!temp.isEmpty())
//             stack.add(temp.pop());
//         stack.add(arr[i]);
//         return count;
// }