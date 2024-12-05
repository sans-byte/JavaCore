package GFG160;

import java.util.Arrays;

public class Sort0s1sand2s {
    public static void main(String[] args) {
        // int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        int arr[] = { 0, 0, 0, 2, 1, 2, 1 };
        sort012(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort012(int[] arr) {
        int i = 0, mid = 0, j = arr.length - 1;

        while (mid <= j) {
            if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 0) {
                swap(mid, i, arr);
                i++;
                mid++;
            } else {
                swap(mid, j, arr);
                j--;
            }
        }
    }
}
