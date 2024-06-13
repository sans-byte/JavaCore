package BinarySearch;

public class SearchInRotatedArray2ndAppoach {
    public static void main(String[] args) {
        int[] arr = { 5,1,3 };
        int target = 0;
        System.out.println(findTarget(arr, target));
    }

    static int findTarget(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target)
                return mid;

            if (arr[start] <= arr[mid]) {
                if (arr[start] <= target && target <= arr[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if (arr[mid] <= target && target <= arr[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}
