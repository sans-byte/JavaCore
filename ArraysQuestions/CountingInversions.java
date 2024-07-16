package ArraysQuestions;

import java.util.Arrays;

public class CountingInversions {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 1, 3, 5 };
        System.out.println(CountInversions(arr));
        System.out.println(Arrays.toString(arr));
    }

    static int CountInversions(int[] arr) {
        // Intution here is to implement merge sort and while merging count the pairs

        // Divide arrays into sorted arrays of half

        // while merging count the number of inversions
        return mergeSortInversionCount(arr, 0, arr.length - 1);
    }

    static int mergeSortInversionCount(int[] arr, int s, int e) {

        int count = 0;

        if (e == s) {
            return count;
        }

        int mid = s + (e - s) / 2;

        count += mergeSortInversionCount(arr, s, mid);
        count += mergeSortInversionCount(arr, mid + 1, e);

        // System.out.println(Arrays.toString(arr));
        count += mergeCount(arr, s, mid, e);

        return count;
    }

    static int mergeCount(int[] arr, int s, int mid, int e) {

        int left = s;
        int right = mid + 1;
        int k = 0;
        int count = 0;
        int[] mix = new int[e - s + 1];

        while (left <= mid && right <= e) {
            if (arr[left] > arr[right]) {
                System.out.println(arr[left] + " " + arr[right]);
                count += mid - left + 1;
                mix[k] = arr[right];
                right++;
                k++;
            } else {
                mix[k] = arr[left];
                left++;
                k++;
            }
        }

        while (left <= mid) {
            mix[k] = arr[left];
            k++;
            left++;
        }

        while (right <= e) {
            mix[k] = arr[right];
            k++;
            right++;
        }
        for (int l = 0; l < mix.length; l++) {
            arr[s + l] = mix[l];
        }

        System.out.println(Arrays.toString(mix));
        return count;
    }
}
