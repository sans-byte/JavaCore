package ArraysQuestions;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/majority-element/

public class MejorityElements {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 3, 1, 1, 1, 12, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 3, 44, 4, 4, 44, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 66, 6, 6 };

        System.out.println(findMajority(nums));
    }

    static int findMajority(int[] arr) {
        // Map<Integer, Integer> m = new HashMap<>();

        // for (int i : arr) {
        //     m.put(i, m.getOrDefault(i, 0) + 1);
        // }

        // int res = -1;
        // int sums = 0;
        // for (int i : m.keySet()) {
        //     if (m.get(i) > sums) {
        //         sums = m.get(i);
        //         res = i;
        //     }
        // }
        // System.out.println(m);
        // return res;


//         Moore Volting Algo

//         Iterate therew the array start from i=0
//         ele = 0;
//         count = 1;

//         while i<arraysize
//         if i appear count++ else count-- 
//         if count = 0 ele = arr[i] count = 1

//         The intution is if an element is appearing n/2 times then it will not get canceled

        int i = 0;
        int ele = arr[0];
        int count = 1;
        while(i < arr.length ){
            if(arr[i] == ele){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                ele = arr[i];
                count = 1;
            }
            i++;
        }
        return ele; //Here it is defined that we definitly have a Majority element 
        // if it is not the case then we have to run a loop check if ele is coming n/2 times
        // else return -1
    }
}
