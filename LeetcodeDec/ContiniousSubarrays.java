package LeetcodeDec;

import java.util.*;

public class ContiniousSubarrays {
    public static void main(String[] args) {
        int nums[] = { 35, 35, 36, 37, 36, 37, 38, 37, 38 };
        System.out.println(continuousSubarrays(nums));
        System.out.println(continuousSubarrays1(nums));
    }

    public static long continuousSubarrays(int[] nums) {
        long res = 0;

        TreeMap<Integer, Integer> sortedMap = new TreeMap<>(); // this gives us a sorted map
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            sortedMap.merge(nums[j], 1, Integer::sum);
            while (!sortedMap.isEmpty() && sortedMap.lastKey() - sortedMap.firstKey() > 2) {
                sortedMap.put(nums[i], sortedMap.get(nums[i]) - 1);
                if (sortedMap.get(nums[i]) == 0) {
                    sortedMap.remove(nums[i]);
                }
                i++;
            }
            res += j - i + 1;
            j++;
        }

        return res;
    }

    // second approch with the help of monotonous deque (increasing or decreasing
    // dequeue)
    public static long continuousSubarrays1(int[] nums) {
        long res = 0;
        ArrayDeque<Integer> maxQueue = new ArrayDeque<>();
        ArrayDeque<Integer> minQueue = new ArrayDeque<>();

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            while (!minQueue.isEmpty() && nums[minQueue.peekLast()] >= nums[j]) {
                minQueue.pollLast();
            }
            minQueue.addLast(j);

            while (!maxQueue.isEmpty() && nums[maxQueue.peekLast()] <= nums[j]) {
                maxQueue.pollLast();
            }
            maxQueue.addLast(j);

            while (!maxQueue.isEmpty() && !minQueue.isEmpty()
                    && nums[maxQueue.peekFirst()] - nums[minQueue.peekFirst()] > 2) {
                if (maxQueue.peekFirst() < minQueue.peekFirst()) {
                    i = maxQueue.peekFirst() + 1;
                    maxQueue.pollFirst();
                } else {
                    i = minQueue.peekFirst() + 1;
                    minQueue.pollFirst();
                }
            }
            res += j - i + 1;
        }
        return res;
    }

}
