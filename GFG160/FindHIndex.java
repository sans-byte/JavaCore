package GFG160;

import java.util.*;

public class FindHIndex {
    public static void main(String[] args) {
        int citations[] = { 1,1,1,1,1,1 };
        // int citations[] = { 5, 1, 2, 4, 1 };
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        int max = Arrays.stream(citations).max().getAsInt();
        int value = 0;
        int arr[] = new int[max + 1];
        for (int i = 0; i < citations.length; i++) {
            arr[citations[i]]++;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            value += arr[i];
            if (value >= i) {
                return i;
            }
        }
        return 0;
    }
}
