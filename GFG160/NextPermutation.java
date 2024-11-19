package GFG160;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        // int arr[] = { 2, 4, 1, 7, 5, 0 };
        // int arr[] = { 1, 2, 3, 6, 5, 4 };
        // int arr[] = { 5, 4, 3 };
        int arr[] = { 3, 4, 2, 5, 1 };
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void nextPermutation(int[] arr) {
        int i = arr.length - 1, max = i;
        while (i >= 0) {
            if (arr[i] >= arr[max]) {
                max = i;
            } else {
                int temp = max;
                for (int x = i + 1; x < arr.length; x++) {
                    if (arr[x] < arr[temp] && arr[x] > arr[i]) {
                        temp = x;
                    }
                }
                int tempVal = arr[i];
                arr[i] = arr[temp];
                arr[temp] = tempVal;
                break;
            }
            i--;
        }
        Arrays.sort(arr, i + 1, arr.length);
    }
}
