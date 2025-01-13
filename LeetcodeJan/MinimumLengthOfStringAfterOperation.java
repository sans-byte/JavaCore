package LeetcodeJan;

import java.util.*;

public class MinimumLengthOfStringAfterOperation {
    public static void main(String[] args) {
        String s = "abaacbcbb";
        System.out.println(minimumLength(s));
    }

    public static int minimumLength(String s) {
        Map<Character, List<Integer>> m = new HashMap<>();
        int arr[] = new int[26];
        Arrays.fill(arr, -1);
        int res = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (m.containsKey(s.charAt(i))) {
                List<Integer> temp = m.get(s.charAt(i));
                temp.add(i);
                m.put(s.charAt(i), temp);
            } else {
                m.put(s.charAt(i), new ArrayList<>(Arrays.asList(i)));
            }
        }
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            arr[index]++;
            if (arr[index] % 2 != 0) {
                if (m.get(s.charAt(i)).size() > arr[index] + 1) {
                    res -= 2;
                }
            }
        }
        return res;
    }
}
