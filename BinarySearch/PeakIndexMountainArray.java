package BinarySearch;

// Basically given a mountain array(values increase to a peak then decrease) 
//find the peak index [1,5,10,34,7,5,2] ans = 55

public class PeakIndexMountainArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(findPeakEle(arr));
    }

    static int findPeakEle(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end) {
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid+1]){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
}
