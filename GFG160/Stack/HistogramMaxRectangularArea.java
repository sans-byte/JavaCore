package GFG160.Stack;

import java.util.Stack;

public class HistogramMaxRectangularArea {
    public static void main(String[] args) {
        int arr[] = { 60, 20, 50, 40, 10, 50, 60 };
        System.out.println(getMaxArea(arr));
        System.out.println(getMaxAreaOptimal(arr));
    }

    public static int[] nextSmallerElement(int[] arr) {
        int res[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()])
                stack.pop();
            if (stack.isEmpty()) {
                res[i] = arr.length;
            } else {
                res[i] = stack.peek();
            }
            stack.add(i);
        }
        return res;
    }

    public static int[] previousSmallerElement(int[] arr) {
        int res[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()])
                stack.pop();
            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.add(i);
        }
        return res;
    }

    public static int getMaxArea(int arr[]) {
        int[] nse = nextSmallerElement(arr);
        int[] pse = previousSmallerElement(arr);
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = Math.max(res, (arr[i] * (nse[i] - pse[i] - 1)));
        }
        return res;
    }

    // most optimal solution singel passs

    public static int getMaxAreaOptimal(int arr[]) {
        Stack<Integer> stack = new Stack<>();
        int maxValue = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int element = arr[stack.pop()];
                int nse = i;
                int pse = stack.empty() ? -1 : stack.peek();
                maxValue = Math.max(maxValue, (element * (nse - pse - 1)));
            }
            stack.add(i);
        }
        // still element in stack
        while (!stack.empty()) {
            int element = arr[stack.pop()];
            int nse = arr.length;
            int pse = stack.empty() ? -1 : stack.peek();
            maxValue = Math.max(maxValue, (element * (nse - pse - 1)));
        }
        return maxValue;
    }
}
