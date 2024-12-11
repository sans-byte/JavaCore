package GFG160.Sorting;

import java.util.*;

public class MergeIntervalsWithOutExtraSpace {
    public static void main(String[] args) {
        int a[] = { 1, 5, 9, 10, 15, 20 }, b[] = { 2, 3, 8, 13 };
        mergeArrays(a, b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    public static void mergeArrays(int a[], int b[]) {
        int i = a.length - 1;
        int j = 0;

        while (a[i] > b[j]) {
            int temp = a[i];
            a[i] = b[j];
            b[j] = temp;
            i--;
            j++;
        }

        Arrays.sort(a);
        Arrays.sort(b);
    }

    // can also be done with the help of gap method which also gives the same time
}
