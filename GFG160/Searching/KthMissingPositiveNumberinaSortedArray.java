package GFG160.Searching;

// https://youtube.com/watch?v=uZ0N_hZpyps
// TODO: Good quesiton revisit

public class KthMissingPositiveNumberinaSortedArray {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 7, 11 }, k = 5;
        System.out.println(kthMissing(arr, k));
    }

    public static int kthMissing(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r + 1 + k; // or we can also return l + k which can also give the answer
    }
}
