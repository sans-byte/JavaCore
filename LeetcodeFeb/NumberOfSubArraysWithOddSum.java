package LeetcodeFeb;

public class NumberOfSubArraysWithOddSum {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println(numOfSubarrays(arr));
    }

    public static int numOfSubarrays(int[] arr) {
        int oddCount = 0;
        int evenCount = 1;
        int count = 0;
        int mod = 1000000007;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum % 2 == 0) {
                count = (count + oddCount) % mod;
                evenCount++;
            } else {
                count = (count + evenCount) % mod;
                oddCount++;
            }
        }
        return count;
    }
}
               