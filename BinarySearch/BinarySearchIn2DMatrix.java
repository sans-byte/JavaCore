package BinarySearch;

import java.util.Arrays;

// The intution here is to apply the same binary search we do on normal array
// but play with index like 5 index in straight array in a 2d array of n * m will be
// 5 / m = x; 5 % m = y This will provide x and y index of the element in 2d array

public class BinarySearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 20;
        System.out.println(Arrays.toString(binarySearchIn2DMatrix(matrix, target)));
    }

    static int[] binarySearchIn2DMatrix(int[][] arr, int target) {
        int n = arr.length;
        int m = arr[0].length;
        int start = 0;
        int end = n * m - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int nMid = mid / m;
            int mMid = mid % m;
            System.out.println(nMid + " " + mMid);
            if (arr[nMid][mMid] == target) {
                return new int[] {nMid,mMid};
            }else if(arr[nMid][mMid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return new int[] { -1, -1 };
    }
}
