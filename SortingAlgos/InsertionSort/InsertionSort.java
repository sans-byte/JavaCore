package SortingAlgos.InsertionSort;

import java.util.Arrays;

// The intution here is to sort the array partially with every pass
// Take initial parts of the array then check if the arr[j] < arr[j-1] then swap both
// [ 5, 2, 3, 6, 1 ] i = 0 ; j = 1; => [ 2, 5, 3, 6, 1 ]
// [ 5, 2, 3, 6, 1 ] i = 1 ; j = 2; => [ 2, 3, 5, 6, 1 ]
// [ 5, 2, 3, 6, 1 ] i = 2 ; j = 3; => [ 2, 3, 5, 6, 1 ]
// [ 5, 2, 3, 6, 1 ] i = 3 (n-2) ; j = 4(n-1); => [ 1, 2, 3, 5, 6 ]

// In any pass if arr[j] > arr[j-1] then break; coz the previous array is already sorted.

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 3, 6, 1 };
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    static void insertionSort(int[] arr) {
        for (int i = 0; i <= arr.length - 2; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }
}

// Time complexity worst case = O(n2) best case = O(n)
// Works good with array those are partially sorted
// that's why takes place in hybrid sorting algos

// It's a stable sorting algorithm