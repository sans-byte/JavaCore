package BinarySearch;

// Find the ciel of a number in an sorted array ex: [1,3,4,6,7,12,45,67] target = 12 ans= 12

//                                                                                43 ans = 45

// [1,3,4,6,7,12,45,67]

public class CielInArray {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 6, 7, 12, 45, 67 };
        int target = 3;
        System.out.println(findCiel(arr, target));
    }

    static int findCiel(int[] arr, int target) {
        if (arr.length <= 0)
            return -1;

        int start = 0;
        int end = arr.length - 1;
        int cielElement = -1;
        while (end >= start) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] > target) {
                cielElement = arr[mid];
                end = mid-1;
            }else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                cielElement = arr[mid];
                return cielElement;
            }
        }
        return cielElement;
    }
}
