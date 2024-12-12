package GFG160.Searching;

public class NumberOfOccurance {
    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 2, 2, 2, 3 }, target = 2;
        System.out.println(countFreq(arr, target));
    }

    public static int countFreq(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int first = -1;
        int last = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

            if (arr[mid] == target)
                first = mid;
        }

        if (first == -1)
            return -1;

        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (arr[m] <= target) {
                s = m + 1;
            } else {
                e = m - 1;
            }
            if (arr[m] == target) {
                last = m;
            }
        }
        System.out.println(first);
        System.out.println(last);
        return last - first + 1;
    }

}
