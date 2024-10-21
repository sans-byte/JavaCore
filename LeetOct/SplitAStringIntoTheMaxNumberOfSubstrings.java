package LeetOct;

// https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/

import java.util.*;

public class SplitAStringIntoTheMaxNumberOfSubstrings {
    public static void main(String args[]) {
        String s = "aajejucjejayaaat";
        System.out.println(maxUniqueSplit(s));
    }

    public static int maxUniqueSplit(String s) {
        int ans[] = new int[1];
        backtrack(0,s,new HashSet<>(),ans);
        return ans[0];
    }

    public static void backtrack(int start, String s, HashSet<String> set,int[] ans){
        if(start == s.length()){
            ans[0] = Math.max(set.size(),ans[0]);
            return;
        }
        int maxSplits = 0;
        for(int end = start+1; end<= s.length(); end++){
            String substring = s.substring(start,end);
            if(!set.contains(substring)){
                set.add(substring);
                backtrack(end,s,set,ans);
                set.remove(substring);
            }
        }
        return;
    }
}
