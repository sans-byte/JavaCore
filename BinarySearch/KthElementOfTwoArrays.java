package BinarySearch;

import LeetOct.MaxChampion2;

// Mostly same is find the median of two sorted arrays

public class KthElementOfTwoArrays {
    public static void main(String[] args) {
        // int a[] = { 2, 3, 6, 7, 9 }, b[] = { 1, 4, 8, 10 }, k = 5;
        int a[] = { 5, 5, 8, 8, 8, 9, 11, 11, 11, 11, 11 }, b[] = { 4, 4, 4, 4, 6, 8, 9, 9, 9, 11, 13 }, k = 2;
        System.out.println(kthElement(a, b, k));
    }

    public static int kthElement(int a[], int b[], int k) {
        int n1 = a.length;
        int n2 = b.length;

        if (n1 > n2)
            return kthElement(b, a, k);

        int left = Math.max(k - n2, 0);
        int right = Math.min(k, n1);
        while (left <= right) {
            int mid1 = left + (right - left) / 2;
            int mid2 = k - mid1;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            if (mid1 < n1)
                r1 = a[mid1];
            if (mid2 < n2)
                r2 = b[mid2];
            if (mid1 - 1 >= 0)
                l1 = a[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = b[mid2 - 1];

            if (l1 <= r2 && l2 <= r1)
                return Math.max(l1, l2);
            else {
                if (l2 > r1)
                    left = mid1 + 1;
                else
                    right = mid1 - 1;
            }
        }
        return 0;
    }
}
