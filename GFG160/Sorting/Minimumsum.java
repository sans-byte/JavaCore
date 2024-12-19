package GFG160.Sorting;

import java.util.Arrays;

public class Minimumsum {
    public static void main(String[] args) {
        // int arr[] = { 6, 8, 4, 5, 2, 3 };
        // int arr[] = { 5, 3, 0, 7, 4 };
        int[] arr = {
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
                4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 7, 7, 7, 7, 7, 7, 7, 7, 7,
                7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 77, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
                7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
                9, 9, 99, 9, 99, 9, 9, 9, 9, 9, 9, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 11, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1
        };
        System.out.println(minSum(arr));
    }

    public static String minSum(int[] arr) {
        Arrays.sort(arr);
        int carry = 0;
        StringBuilder res = new StringBuilder();
        for (int i = arr.length - 2; i >= 0; i -= 2) {
            int total = arr[i] + arr[i + 1] + carry;
            carry = total / 10;
            int val = total % 10;
            res.append(Integer.toString(val));
        }
        if (arr.length % 2 != 0) {
            res.append(Integer.toString(carry + arr[0]));
        } else {
            if (carry != 0) {
                res.append(Integer.toString(carry));
            }
        }
        res.reverse();
        return res.toString().replaceFirst("^0+", "");
    }
}
