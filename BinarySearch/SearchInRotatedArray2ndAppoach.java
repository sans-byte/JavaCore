package BinarySearch;

public class SearchInRotatedArray2ndAppoach {
    public static void main(String[] args) {
        int[] arr = { 5, 1, 3 };
        int target = 0;
        System.out.println(findTarget(arr, target));
        System.out.println(search(arr, target));
    }

    // one more approach for this i used in GFG160
    public static int binarySearch(int l, int r, int target, int[] arr) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int flag = 0;
        int pivot = 0;
        while (l < r) {
            if (nums[r] > nums[l]) {
                pivot = r;
                flag = 1;
                break;
            }
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[l]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        if (flag == 0) {
            pivot = l;
        }
        if (target < nums[0]) {
            return binarySearch(pivot + 1, nums.length - 1, target, nums);
        }
        return binarySearch(0, pivot, target, nums);
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
