package BinarySearch;

public class FindMinValueInRotatedArray {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 5, 6, 1, 2 };
        System.out.println(findMinInRotatedArray(arr));
    }

    static int findMinInRotatedArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return arr[mid + 1];
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return arr[mid];
            }
            if (arr[start] <= arr[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return arr[start];
    }
}
