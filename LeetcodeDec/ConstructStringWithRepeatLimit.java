package LeetcodeDec;

import java.util.*;

public class ConstructStringWithRepeatLimit {

    public static void main(String[] args) {
        // String s = "aababab";
        // int repeatLimit = 2;

        String s = "cczazcc";
        int repeatLimit = 3;
        System.out.println(repeatLimitedString(s, repeatLimit));
    }

    public static String repeatLimitedString(String s, int repeatLimit) {
        String res = "";
        int arr[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        int temp = -1;
        for (int i = 25; i >= 0; i--) {
            if (arr[i] == 0)
                continue;
            while (temp != -1 && arr[i] != 0) {
                res += (char) (i + 'a');
                arr[i]--;

                for (int x = 0; x < repeatLimit && arr[temp] > 0; x++) {
                    res += (char) (temp + 'a');
                    arr[temp]--;
                }

                if (arr[temp] == 0)
                    temp = -1;
            }
            for (int x = 0; x < repeatLimit && arr[i] > 0; x++) {
                res += (char) (i + 'a');
                arr[i]--;
            }
            if (arr[i] != 0) {
                temp = i;
            }
        }
        return res;
    }
}