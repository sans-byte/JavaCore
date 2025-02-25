package LeetcodeFeb;

public class NumberOfSubArraysWithOddSum {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println(numOfSubarrays(arr));
    }

    public static int numOfSubarrays(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum % 2 != 0)
                    count++;
            }
        }
        return count;
    }
}
               