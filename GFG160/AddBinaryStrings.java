package GFG160;

import java.util.*;

public class AddBinaryStrings {
    public static void main(String[] args) {
        String s1 = "1101", s2 = "111";
        System.out.println(addBinary(s1, s2));
    }

    public static String addBinary(String s1, String s2) {
        int carry = 0;
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        String res = new String();
        while (i >= 0 && j >= 0) {
            if (s1.charAt(i) == '0' && s2.charAt(j) == '0') {
                if (carry == 0) {
                    res += '0';
                } else {
                    res += '1';
                    carry = 0;
                }
            } else if (s1.charAt(i) == '1' && s2.charAt(j) == '0') {
                if (carry == 0) {
                    res += '1';
                } else {
                    res += '0';
                    carry = 1;
                }
            } else if (s1.charAt(i) == '0' && s2.charAt(j) == '1') {
                if (carry == 0) {
                    res += '1';
                } else {
                    res += '0';
                    carry = 1;
                }
            } else {
                if (carry == 0) {
                    res += '0';
                    carry = 1;
                } else {
                    res += '1';
                    carry = 1;
                }
            }
            i--;
            j--;
        }

        while (i >= 0) {
            if (s1.charAt(i) == '1') {
                if (carry == 1) {
                    res += '0';
                    carry = 1;
                } else {
                    res += '1';
                }
            } else {
                if (carry == 1) {
                    res += '1';
                    carry = 0;
                } else {
                    res += '0';
                }
            }
            i--;
        }
        while (j >= 0) {
            if (s2.charAt(j) == '1') {
                if (carry == 1) {
                    res += '0';
                    carry = 1;
                } else {
                    res += '1';
                    carry = 0;
                }
            } else {
                if (carry == 1) {
                    res += '1';
                    carry = 0;
                } else {
                    res += '0';
                }
            }
            j--;
        }

        if (carry == 1) {
            res += '1';
        }

        StringBuilder temp = new StringBuilder(res);
        i = temp.length() - 1;
        while (temp.charAt(i) == '0')
            i--;
        temp.delete(i + 1, temp.length());

        res = temp.reverse().toString();

        return res;
    }
}
