package SortingAlgos.CyclicSort;

import java.util.Arrays;

//https://leetcode.com/problems/first-missing-positive/
// Leetcode hard question
// In this question it's not given range (1,n) but after seeing the question we can 
// that for finding the smallest positive integer we can use this method

public class FindMissingPosive {
    public static void main(String[] args) {
        int[] nums = { 3, 4, -1, 1 };
        findCorrectIndex(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                System.out.println(i+1);
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    static void findCorrectIndex(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] <= 0 || arr[i] > arr.length)
                i++;
            else {
                int correctIndex = arr[i] - 1;
                if (arr[i] != arr[correctIndex]) {
                    swap(arr, i, correctIndex);
                } else {
                    i++;
                }
            }
        }
    }
}
