package Strings;

import java.util.ArrayList;
import java.util.List;

// We are going to use here the concept of power set

public class PrintAllSubstrings {

    public static void main(String[] args) {
        String str = "abc";
        List<Character> resStr = new ArrayList<>();
        // printSubstrings(str);
        // printAllSubstrWithRecursion(str, 0, resStr);

        int[] nums = { 1, 2, 3 };
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> resStrInt = new ArrayList<>();
        printAllSubstrWithRecursionInt(nums, 0, resStrInt, res);
        System.out.println(res);
    }

    static void printSubstrings(String str) {
        // Here we know that for n length of string total number of substrings will be
        // 2^n-1
        // so we can use bits here to see if we want to pick a letter or not if the
        // value is set then that letter is to be picked
        // 0 0 0 0 -> ""
        // 1 0 0 1 -> "c"
        // 2 0 1 0 -> "b"
        // 0 -> n-1 // 3 0 1 1 -> "bc"
        // 4 1 0 0 -> "a"
        // 5 1 0 1 -> "ac"
        // 6 1 1 0 -> "ab"
        // 7 1 1 1 -> "abc"
        // check if i th bit is set or not for example let's i = 2;
        // if k = 3 -> 0 1 1 then
        // 1 <<(left shift) i => 1 0 0
        // k & ( 1<<i ) = 1 which means the ith bit is set if the answer was 0 then the
        // ith bit is not set

        int val = (int) Math.pow(2, str.length()) - 1;
        for (int x = 0; x < val; x++) {
            String s = new String();
            int i = 0;
            while (i < str.length()) {
                if ((x & (1 << i)) != 0) {
                    s += str.charAt(i);
                }
                i++;
            }
            System.out.println(s);
        }
    }
    // Time complexity -> 2^n * n

    // with recursion
    static void printAllSubstrWithRecursion(String str, int i, List<Character> resStr) {
        if (i >= str.length()) {
            System.out.println(resStr);
            return;
        }
        resStr.add(str.charAt(i));
        printAllSubstrWithRecursion(str, i + 1, resStr);
        resStr.remove(resStr.size() - 1);
        printAllSubstrWithRecursion(str, i + 1, resStr);
    }

    static void printAllSubstrWithRecursionInt(int[] nums, int i, List<Integer> resList, List<List<Integer>> res) {
        if (i >= nums.length) {
            // res.add(resList); cannot do this because
            // The issue lies in the way you're adding the resList to the res list.
            // In Java, when you add an object to a list, you're actually adding a reference
            // to that object. So, when you modify the resList object later, the changes are
            // reflected in the res list as well.
            // In your code, you're adding the resList to the res list in the base case of
            // the recursion, and then you're removing elements from the resList in the
            // recursive calls. This results in empty lists being added to the res list.

            res.add(new ArrayList<Integer>(resList));
            return;
        }
        resList.add(nums[i]);
        printAllSubstrWithRecursionInt(nums, i + 1, resList, res);
        resList.remove(resList.size() - 1);
        printAllSubstrWithRecursionInt(nums, i + 1, resList, res);
    }

    // Time complexity = 2^N
}
