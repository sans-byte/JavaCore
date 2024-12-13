package GFG160.Searching;

public class SortedAndRotatedMinimum {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        System.out.println(findMin(arr));
    }

    public static int findMin(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < arr[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return arr[r];
    }
}
