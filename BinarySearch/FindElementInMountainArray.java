package BinarySearch;
//https://leetcode.com/problems/find-in-mountain-array/

//Given you a mountain array and a target have to find the target and return the lowest index;

public class FindElementInMountainArray {

    public static void main(String[] args) {
        int[] arr = {3,5,3,2,0};
        int target = 5;
        System.out.println(findInMountainArray(arr, target));
    }

    static int findPeakEle(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    static int OrderAgnosticBinarySearch(int[] arr, int i, int j, int target, boolean isIncreasing) {
        int start = i;
        int end = j;
        int findEle = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                findEle =  mid;
                if (isIncreasing) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] > target) {
                if (isIncreasing) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (isIncreasing) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return findEle;
    }

    static int findInMountainArray(int[] arr, int target) {
        int peakEle = findPeakEle(arr);
        int lastIndex = arr.length - 1;
        int i = OrderAgnosticBinarySearch(arr, 0, peakEle, target, true);
        if(i != -1 ) return i;
        int j = OrderAgnosticBinarySearch(arr, peakEle + 1, lastIndex, target, false);
        return j;
    }

}
