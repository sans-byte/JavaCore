package SortingAlgos.MergeSOrt;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = { 8, 5, 2, 9, 1, 2, 4 };

        System.out.println(Arrays.toString(mergeSortArray(arr)));
    }

    static int[] mergeSortArray(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = mergeSortArray(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSortArray(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] res = new int[left.length + right.length];
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                res[k] = left[i];
                i++;
            } else {
                res[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            res[k] = left[i];
            k++;
            i++;
        }

        while (j < right.length) {
            res[k] = right[j];
            k++;
            j++;
        }

        return res;
    }
}
