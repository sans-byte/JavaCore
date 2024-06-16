package BubbleSort;

import java.util.Arrays;

// Time Best Case = O(N) Worst Case = O(N2)
//AKA sinking sort and exchange sort
// It is a stable sorting algorithm which means the order after sorting is maintained
// EX - R-red, B-black {10(B),20(B),30(B),10(R),30(R),20(R)} after sorting = {10(B),10(R),20(B),20(R),30(B),30(R)}

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 3, 5, 6, 1, 9, 7, 12, 14, 15, 11, 25, 22, 24 };
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }

    static int[] bubbleSort(int[] arr) {

        return arr;
    }
}
