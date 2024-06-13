package BinarySearch;

// Given a rotated sorted array ex : {4,5,6,7,0,1,2} and a target find target in the array

// Approach 1;
// find the pivot( basically the largest value in the array ) and apply binary search in left and 
// righ array start to pivot and pivot to end
// ** How to find the pivot element **
// if some element is greater that it's next that thats the pivot
// or if an element is smaller than its pre then pre is pivot element
// now for the conditions to fall into above two statents we need to decrease the window
// we can do that by below conditions
// if(arr[start] <= arr[mid]) then all the elements after mid are smaller than start to discard 
// those start = mid
// else if(arr[start] > arr[mid]) then all the elements before mid are smaller than it so 
// discard those end = mid-1
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;
        int pivot = findPivot(arr);
        System.out.println(pivot);
        if (pivot == -1)
            System.out.println(binarySearch(arr, 0, arr.length - 1, target));
        else {
            int value1 = binarySearch(arr, 0, pivot, target);
            if (value1 != -1)
                System.out.println(value1);
            int value2 = binarySearch(arr, pivot+1, arr.length - 1, target);
            System.out.println(value2);
        }
    }

    static int findPivot(int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (m > s && arr[m] < arr[m - 1]) {
                return m - 1;
            }
            if (m < e && arr[m] > arr[m + 1]) {
                return m;
            }
            if (arr[s] >= arr[m]) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return -1;
    }

    static int binarySearch(int[] arr,int i,int j,int target){
        if(arr == null || arr.length <=0 || j < i) return -1; 
        int mid = i + (j - i)/2; //this won't exceed the limit
        if(arr[mid] == target) return mid;
        if(arr[mid] > target) return binarySearch(arr,i,mid-1 ,target);
        if(arr[mid] < target) return binarySearch(arr, mid+1, j, target);
        return -1;
    }
}