package ArraysQuestions;

import java.util.HashMap;

public class LongestSubArrayWithKSum {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int k = 3;

        System.out.println(longestSubArray(arr, k));
    }

    static int longestSubArray(int[] arr, int k) {

        HashMap<Integer, Integer> sumF = new HashMap<>();
        sumF.put(0, 1);
        
        int cSum = 0;
        int count = 0;
        
        for (int num : nums) {
            cSum += num;
            
            if (sumF.containsKey(cSum - k)) {
                count += sumF.get(cSum - k);
            }
            sumF.put(cSum, sumF.getOrDefault(cSum, 0) + 1);
        }
        
        return count;
    }
}
