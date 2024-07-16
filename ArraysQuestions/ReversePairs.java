package ArraysQuestions;

import java.util.Arrays;

// https://leetcode.com/problems/reverse-pairs/
public class ReversePairs {

    public static void main(String[] args) {
        int[] arr = { 1,3,2,3,1 };

        System.out.println(countReversePairs(arr));
        System.out.println(Arrays.toString(arr));
    }

    static int countReversePairs(int[] arr) {
        return mergeSortCountReversePairs(arr, 0, arr.length - 1);
    }

    static int mergeSortCountReversePairs(int[] arr, int s, int e) {
        int count = 0;

        if (s == e)
            return count;

        int mid = s + (e - s) / 2;

        count += mergeSortCountReversePairs(arr, s, mid);
        count += mergeSortCountReversePairs(arr, mid + 1, e);

        count += countPairs(arr, s, mid, e);

        merge(arr, s, mid, e);
        return count;
    }

    static int countPairs(int[] arr, int s, int mid, int e) {
        int right = mid + 1;
        int count = 0;

        for (int i = s; i <= mid; i++) {
            while (right <= e && arr[i] > 2 * arr[right]) {
                right++;
            }
            count += right - (mid + 1);
        }

        return count;

    }

    static void merge(int[] arr, int s, int mid, int e) {
        int left = s;
        int right = mid + 1;
        int k = 0;
        int count = 0;
        int[] mix = new int[e - s + 1];

        while (left <= mid && right <= e) {
            if (arr[left] > arr[right]) {
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
    }
}
