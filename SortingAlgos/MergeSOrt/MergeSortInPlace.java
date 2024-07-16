
package SortingAlgos.MergeSOrt;

import java.util.Arrays;

public class MergeSortInPlace {

    public static void main(String[] args) {
        int[] arr = { 8, 5, 2, 9, 1, 2, 4 };

        mergeSortArrayInPlace(arr, 0, arr.length);

        System.out.println(Arrays.toString(arr));
    }

    static void mergeSortArrayInPlace(int[] arr, int s, int e) {
        if (e - s <= 1) {
            return;
        }

        int mid = s + (e - s) / 2;

        mergeSortArrayInPlace(arr, 0, mid);
        mergeSortArrayInPlace(arr, mid, e);

        merge(arr, s, mid, e);
    }

    static void merge(int[] arr, int s, int mid, int e) {
        int[] mix = new int[e - s];
        int i = s;
        int j = mid;
        int k = 0;

        while (i < mid && j < e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < mid) {
            mix[k] = arr[i];
            k++;
            i++;
        }

        while (j < e) {
            mix[k] = arr[j];
            k++;
            j++;
        }

        for (int l = 0; l < mix.length; l++) {
            arr[s + l] = mix[l];
        }
    }
}
