package LeetcodeDec;

import java.util.*;

public class FindScoreofanArrayAfterMarkingAllElements {
    public static void main(String[] args) {
        int nums[] = { 2, 3, 5, 1, 3, 2 };
        System.out.println(findScore(nums));
    }

    public static long findScore(int[] nums) {
        // int arr[] = new int[nums.length];
        // long res = 0;
        // while (true) {
        // int min = Integer.MAX_VALUE;
        // int index = -1;
        // for (int j = 0; j < nums.length; j++) {
        // if (arr[j] == 0) {
        // if (nums[j] < min) {
        // index = j;
        // min = nums[j];
        // }
        // }
        // }
        // if (index == -1) {
        // break;
        // }
        // res += min;
        // arr[index] = 1;
        // if (index + 1 < arr.length)
        // arr[index + 1] = 1;
        // if (index - 1 >= 0)
        // arr[index - 1] = 1;
        // }
        // return res;

        // Better approach
        // int res = 0;
        // int arr[] = new int[nums.length];
        // int sortedNums[] = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        // sortedNums[i] = nums[i];
        // }
        // Arrays.sort(sortedNums);
        // Map<Integer, PriorityQueue<Integer>> m = new HashMap<>();
        // for (int i = 0; i < nums.length; i++) {
        // if (m.containsKey(nums[i])) {
        // PriorityQueue<Integer> pq = m.get(nums[i]);
        // pq.add(i);
        // m.put(nums[i], pq);
        // } else {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // pq.add(i);
        // m.put(nums[i], pq);
        // }
        // }

        // for (int i = 0; i < sortedNums.length; i++) {
        // int val = sortedNums[i];
        // if (!m.get(val).isEmpty()) {
        // int index = m.get(val).poll();
        // if (arr[index] == 0) {
        // res += val;
        // arr[index] = 1;
        // if (index + 1 < arr.length)
        // arr[index + 1] = 1;
        // if (index - 1 >= 0)
        // arr[index - 1] = 1;
        // }
        // }
        // }

        // return res;

        // Best approach

        long res = 0;
        int temp[][] = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            temp[i][0] = nums[i];
            temp[i][1] = i;
        }

        Arrays.sort(temp, (x, y) -> Integer.compare(x[0], y[0]));

        int flag[] = new int[nums.length];

        for (int i = 0; i < temp.length; i++) {
            int val = temp[i][0];
            int idx = temp[i][1];

            if (flag[idx] == 0) {
                res += val;
                flag[idx] = 1;
                if (idx - 1 >= 0)
                    flag[idx - 1] = 1;
                if (idx + 1 < flag.length)
                    flag[idx + 1] = 1;
            }
        }
        return res;
    }

    // TODO :
    // https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/solutions/6095499/greedybeats-100-you-can-do-it-in-on-by-w-taol/
    // look into this soln too its really nice
}
