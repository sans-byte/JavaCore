package ArraysQuestions;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/3sum/description/

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
    }

    // Two sum on a sorted array
    static List<Integer> twoSum(int[] numbers,int start,int sum){
        int i = 0;
        int j = numbers.length - 1;
        List<Integer> res = new ArrayList<>();
        int targetSum = 0;
        while(i<j){
            if(i == start) i++;
            if(j == start) j--;
            targetSum = numbers[i] + numbers[j] + sum;
            if(targetSum == 0){
                res.add(numbers[i]);
                res.add(numbers[j]);
                return res;
            }
            if(targetSum > 0) j--;
            else i++;
        }
        return res;
    }
}
