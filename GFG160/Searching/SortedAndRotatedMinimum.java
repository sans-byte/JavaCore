package GFG160.Searching;

public class SortedAndRotatedMinimum {
    public static void main(String[] args) {
        int arr[] = { 1, 4, 3, 2 };
        System.out.println(findMin(arr));
    }

    public static int findMin(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid + 1 < arr.length && arr[mid + 1] < arr[mid]) {
                l = mid + 1;
            } else if (mid - 1 >= 0 && arr[mid - 1] < arr[mid]) {
                r = mid - 1;
            } else {
                return arr[mid];
            }
        }
        return 0;
    }
}
