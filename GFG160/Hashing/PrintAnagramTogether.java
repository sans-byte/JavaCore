package GFG160.Hashing;

import java.util.*;

public class PrintAnagramTogether {
    public static void main(String[] args) {
        // String[] arr = { "act", "god", "cat", "dog", "tac" };
        // String[] arr = { "no", "on", "is" };
        String[] arr = { "listen", "silent", "enlist", "abc", "cab", "bac", "rat",
        "tar", "art" };
        System.out.println('a' < 'b');
        System.out.println(anagrams(arr));
        System.out.println(anagrams1(arr));
    }

    public static int[] createArray(String str) {
        int arr[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        return arr;
    }

    public static ArrayList<ArrayList<String>> anagrams(String[] arr) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        Set<String> s = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int arr1[] = createArray(arr[i]);
            if (s.contains(arr[i]))
                continue;
            s.add(arr[i]);
            ArrayList<String> temp = new ArrayList<>();
            temp.add(arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                int arr2[] = createArray(arr[j]);
                System.out.println(Arrays.toString(arr2));
                if (Arrays.equals(arr1, arr2)) {
                    temp.add(arr[j]);
                    s.add(arr[j]);
                }
            }
            res.add(temp);
        }

        Collections.sort(res, new Comparator<List<String>>() {
            public int compare(List<String> x, List<String> y) {
                System.out.println(x.get(0).charAt(0));
                if (x.get(0).charAt(0) > y.get(0).charAt(0))
                    return 1;
                if (x.get(0).charAt(0) < y.get(0).charAt(0))
                    return -1;

                return 0;
            }
        });
        return res;
    }
}
