package GFG160;

//Kadane's algo

public class KadaneAlgo {
    public static void main(String[] args) {
        int arr[] = { 2, 3, -8, 7, -1, 2, 3 };
        System.out.println(maxSubarraySum(arr));
    }

    static int maxSubarraySum(int[] arr) {
        int maxSum = arr[0], sum = maxSum, i = 1;
        while (i < arr.length) {
            if (sum < 0) {
                sum = 0;
            }
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);
            i++;
        }
        return maxSum;
    }
}
