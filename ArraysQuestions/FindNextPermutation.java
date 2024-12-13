package ArraysQuestions;

import java.util.Arrays;

// https://leetcode.com/problems/next-permutation/
public class FindNextPermutation {
    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 1 };

        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void nextPermutation(int[] arr) {

        int index = -1;

        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                index = i - 1;
                break;
            }
        }

        if (index == -1) {
            reverse(arr, 0);
            return;
        }

        int smallest = Integer.MAX_VALUE;
        int smallIndex = -1;
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] == 0)
                continue;
            if (arr[i] < smallest && arr[i] > arr[index])
                smallIndex = i;
        }

        swap(arr, index, smallIndex);

        reverse(arr, index + 1);
    }

    static void reverse(int[] arr, int i) {
        int j = arr.length - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
