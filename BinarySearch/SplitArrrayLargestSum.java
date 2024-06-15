package BinarySearch;

// https://leetcode.com/problems/split-array-largest-sum/ (Leetcode Hard)
// Input: nums = [7,2,5,10,8], k = 2
// Output: 18
// We need to split the array into given number of pieces and then return the minimum value 
// from the max of both pieces
// [ 7 ] [ 2,5,10,8 ]
//  7       25              => 25
// [ 7,2 ] [ 5,10,8 ]
//  9           23          => 23
// [ 7,2,5 ] [ 2,5,10,8 ]
//  14             18       => 18       => Ans as this is the smallest
// [ 7,2,5,10 ] [ 8 ]
//      24        8         => 24
// Explanation: There are four ways to split nums into two subarrays.
// The best way is to split it into [7,2,5] and [10,8], where the largest sum 
// among the two subarrays is only 18.

// Approach
// We need to find a range in which the answer will be found
// 1. If K = n then array will be split like -> [7][2][5][10][8] Ans -> 10
// 2. If K = 1 then the array will be split like -> [7,,2,5,10,8] Ans -> Sum(Array) -> 32
// Now we have a range = ( 10, 32 ) 
// While ( s < e )
// let's find the mid => mid = 10 + 32 / 2 = 21
// We will split the array such that the sum of an individual array does not exceed 21
// so [ 7,2,5 ] [10,8] pieces = 2     
// If ( pieces <= k ) e = m
// so Now s = 10 e = 21 m = 15
// [7,2,5] [10] [8]
// if(pieces > k) s = m + 1
// s = 16 e = 21 m = 18
// Now when the loop ends we will have our answer in mid = s = e = ans 

public class SplitArrrayLargestSum {
    public static void main(String[] args) {
        int[] arr = { 7, 2, 5, 10, 8 };
        int k = 2;

        System.out.println(splitArrayLargestSum(arr, k));
    }

    static int splitArrayLargestSum(int[] arr, int k) {
        int start = 0;
        int end = 0;
        for (int i : arr) {
            start = Math.max(i, start);
            end += i;
        }
        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = 0;
            int pieces = 1;
            for (int num : arr) {
                if (sum + num <= mid) {
                    sum += num;
                } else {
                    sum = num;
                    pieces++;
                }
            }
            if (pieces <= k)
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }
}
