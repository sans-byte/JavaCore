package LeetcodeJan;

import java.util.Arrays;

public class FindthePrefixCommonArrayofTwoArrays {
    public static void main(String[] args) {
        int A[] = { 1, 3, 2, 4 }, B[] = { 3, 1, 2, 4 };
        System.out.println(Arrays.toString(findThePrefixCommonArray(A, B)));
    }

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int arr[] = new int[A.length + 1];
        int res[] = new int[A.length];
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (++arr[A[i]] == 2)
                count++;
            if (++arr[B[i]] == 2)
                count++;
            res[i] = count;
        }
        return res;
    }
}
