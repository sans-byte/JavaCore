package SelectionSort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 3, 6, 1 };
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int lastIndex = arr.length - i - 1;
            int maxItemIndex = findMax(arr, lastIndex);
            swap(arr, lastIndex, maxItemIndex);
        }
    }

    static void swap(int[] arr, int lastIndex, int maxItemIndex) {
        int temp = arr[lastIndex];
        arr[lastIndex] = arr[maxItemIndex];
        arr[maxItemIndex] = temp;
    }

    static int findMax(int[] arr, int lastIndex) {
        int maxIndex = 0;
        for (int j = 0; j <= lastIndex; j++) {
            if (arr[j] > arr[maxIndex]) {
                maxIndex = j;
            }
        }
        return maxIndex;
    }
}
