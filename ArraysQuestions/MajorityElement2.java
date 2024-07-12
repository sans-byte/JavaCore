package ArraysQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/majority-element-ii/

public class MajorityElement2 {
    public static void main(String[] args) {
        // int[] nums = { 3, 2, 3, 5, 5, 5, 1, 1, 1, 3, 3, 3, 5, 5, 5, 5, 5, 1, 1, 1, 1,
        // 5, 1, 3, 5, 1 };
        // int[] nums = { 2, 2 };
        int[] nums = { 4, 1, 2, 3, 4, 4, 3, 2, 1, 4 };

        System.out.println(findMejority(nums));

    }

    // we need to find elements which are appearing more than n/3 times
    // so At Max there can be only 2 elements which can appear >n/3 times
    // So the answer will be 1 or 2 elements

    static List<Integer> findMejority(int[] arr) {
        int i = 0;
        int current1 = Integer.MIN_VALUE;
        int current2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;

        while (i < arr.length) {
            if (count1 == 0 && arr[i] != current2) {
                current1 = arr[i];
                count1 = 1;
            } else if (count2 == 0 && arr[i] != current1) {
                current2 = arr[i];
                count2 = 1;
            } else if (arr[i] == current1) {
                count1++;
            } else if (arr[i] == current2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
            i++;
        }

        List<Integer> res = new ArrayList<>();

        count1 = 0;
        count2 = 0;

        for (int x = 0; x < arr.length; x++) {
            if (arr[x] == current1)
                count1++;
            if (arr[x] == current2)
                count2++;
        }

        int mini = (int) ((arr.length / 3) + 1);

        if (count1 >= mini)
            res.add(current1);
        if (count2 >= mini)
            res.add(current2);

        res.sort(null);

        return res;
    }
}
