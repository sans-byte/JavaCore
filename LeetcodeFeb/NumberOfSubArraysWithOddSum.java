package LeetcodeFeb;

public class NumberOfSubArraysWithOddSum {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 5 };
        System.out.println(numOfSubarrays(arr));
    }

    public static void getAllSubArrays(int[] arr, int i, int sum, int[] count) {
        if (i >= arr.length) {
            if (sum % 2 != 0)
                count[0]++;
            return;
        }
    }

    public static int numOfSubarrays(int[] arr) {
        int count[] = new int[] { 0 };
        getAllSubArrays(arr, 0, 0, count);
        return count[0];
    }
}
