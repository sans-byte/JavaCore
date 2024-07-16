package SortingAlgos.BubbleSort;

import java.util.Arrays;

// Time Best Case = O(N) Worst Case = O(N2)
//AKA sinking sort and exchange sort
// It is a stable sorting algorithm which means the order after sorting is maintained
// EX - R-red, B-black {10(B),20(B),30(B),10(R),30(R),20(R)} after sorting = {10(B),10(R),20(B),20(R),30(B),30(R)}

// If the array is sorted that means we need not to run loop for n2 times we can break the program after first iteration
public class BubbleSort {
    public static void main(String[] args) {
        // int[] arr = { 3, 5, 6, 1, 9, 7, 12, 14, 15, 11, 25, 22, 24 };
        int[] arr = {1,2,3,4,5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                // We do check and swapping here
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
    }
}
