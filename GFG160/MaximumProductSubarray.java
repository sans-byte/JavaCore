package GFG160;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int arr[] = { -2, 6, -3, -10, 0, 2 };
        System.out.println(maxProduct(arr));
    }

    static int maxProduct(int[] arr) {
        int i = 0, j = 1, product = arr[i], max = product;
        while (i < arr.length && j < arr.length) {
            product *= arr[j];
            if (product < 0) {
                if (arr[j] > 0) {

                } else {

                }
            }
        }
        return max;
    }
}
