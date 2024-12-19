package GFG160.Sorting;

import java.util.*;

// Need to make it right giving wrong answer

public class FormtheLargestNumber {
    public static void main(String[] args) {
        int arr[] = { 3, 30, 34, 5, 9 };
        System.out.println(findLargest(arr));
    }

    public static String findLargest(int[] arr) {
        if (Arrays.stream(arr).max().getAsInt() == 0)
            return "0";
        int digits[][] = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            digits[i] = Integer.toString(arr[i]).chars().map(x -> x - '0').toArray();
        }
        Arrays.sort(digits, new Comparator<int[]>() {
            public int compare(int[] x, int[] y) {
                int i = 0;
                int j = 0;

                while (i < x.length - 1 || j < y.length - 1) {

                    System.out.println("hello");
                    if (x[i] > y[j])
                        return -1;
                    if (x[i] < y[j])
                        return 1;
                    if (i < x.length - 1)
                        i++;
                    if (j < y.length - 1)
                        j++;
                }

                if (x[i] > y[j])
                    return -1;
                if (x[i] < y[j])
                    return 1;
                return 0;
            }
        });
        for (int[] i : digits) {
            System.out.println(Arrays.toString(i));
        }
        String res = "";
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits[i].length; j++) {
                res += Integer.toString(digits[i][j]);
            }
        }
        System.out.println(res);
        return null;
    }
}
