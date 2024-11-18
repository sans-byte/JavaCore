package LeetOct;

// 862. Shortest Subarray with Sum at Least K

// TODO: Revice again -> Monotonus deque concept

import java.util.*;

public class ShortestSubArrayWithSumAtLeastK {
    public static void main(String[] args) {
        int nums[] = { -28, 81, -20, 28, -29 };
        int k = 89;
        System.out.println(shortestSubarray(nums, k));
    }

    public static int shortestSubarray(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int prefix[] = new int[nums.length + 1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prefix.length - 1; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        for (int i = 0; i < prefix.length; i++) {
            while (!deque.isEmpty() && prefix[i] - prefix[deque.peekFirst()] >= k) {
                min = Math.min(min, i - deque.pollFirst());
            }

            while (!deque.isEmpty() && prefix[i] <= prefix[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
        }
        return min;
    }
}
