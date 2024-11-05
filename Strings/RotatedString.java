package Strings;

import java.util.*;

public class RotatedString {
    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";
        System.out.println((s + s).contains(goal)); // this is with concat strings

        // if (s.length() != goal.length())
        //     System.out.println(false);
        // if (s.equals(goal))
        //     System.out.println(true);
        StringBuilder str = new StringBuilder(s);
        int i = 0;
        while (i < s.length()) {
            str.deleteCharAt(0);
            str.append(s.charAt(i));
            System.out.println(str);
            if (str.toString().equals(goal)) {
                System.out.println(true);
                break;
            }
            i++;
        }
        System.out.println(false);
    }
}
