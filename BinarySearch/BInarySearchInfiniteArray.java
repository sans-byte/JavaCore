package BinarySearch;

import java.util.Arrays;

// we have given an sorted infinite size array (basiclly we cannot use arr.length) and a target

// The idea is that we can traverse the array in chunks increasing the size of the window 
// exponentially ex 2,4,8 this will take logN time
// Then when we find the window in which the target lies we can now find it

// Total complexity = 2LogN -> LogN

public class BInarySearchInfiniteArray {
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,7,8,9,10,23,24,26,28,29,30,31,34,35,37,38,40}; //assume this is an 
        //infinite array
        int target = 30;
        if(arr[0] == target) System.out.println(0);
        System.out.println(Arrays.toString(findRange(arr, target)));
        // binarySearch(arr,indexArr[0],indexArr[1],target);
    }

    static int[] findRange(int[] arr,int target){
        int[] rangeArr = {-1,-1};
        int start = 1;
        int end = 2;
        while(arr[start]< target){
            if(arr[end] > target) {
                rangeArr[0] = start;
                rangeArr[1] = end;
                return rangeArr;
            };
            start = start + start*2;
            end = end + end*2;
        }
        return rangeArr;
    }
}
