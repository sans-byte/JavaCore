package GreedyAlgo;

import java.lang.reflect.Array;
import java.util.Arrays;

// https://leetcode.com/problems/candy/submissions/1336419496/

public class Candy {
    public static void main(String[] args) {
        int[] ratings = { 1, 0, 2 };
        System.out.println(candyOptimised(ratings));
    }

    // Better approach //Using two arrays one considering only left and second
    // considering only right
    static int candy(int[] ratings) {

        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];

        int candy = 1;
        left[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy++;
            } else {
                candy = 1;
            }
            left[i] = candy;
        }

        candy = 1;
        right[right.length - 1] = 1;
        for (int i = right.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy++;
            } else {
                candy = 1;
            }
            right[i] = candy;
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        int sum = 0;
        for (int i = 0; i < left.length; i++) {
            sum += Math.max(left[i], right[i]);
        }

        return sum;

    }

    static int candyOptimised(int[] ratings) {
        int i = 1;
        int n = ratings.length;
        int sum = 1;
        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                sum++;
                i++;
                continue;
            }
            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                sum += peak;
                i++;
            }
            int bottom = 1;
            while (i < n && ratings[i] < ratings[i - 1]) {
                sum += bottom;
                bottom++;
                i++;
            }
            if (bottom > peak) {
                sum += bottom - peak;
            }
        }
        return sum;
    }

}
