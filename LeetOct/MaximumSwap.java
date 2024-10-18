package LeetOct;

import java.util.Arrays;

public class MaximumSwap {
    public static void main(String[] args) {
        int num = 98368;
        System.out.println(maximumSwap(num));
    }

    static public int[] reverse(int[] arr, int i) {
        int x = 0;
        int y = i - 1;
        while (x < y) {
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
            x++;
            y--;
        }
        return arr;
    }

    static public int maximumSwap(int num) {
        int n = num;
        int i = 0;
        while (n > 0) {
            n = n / 10;
            i++;
        }
        int arr[] = new int[i];
        n = num;
        i = 0;
        while (n > 0) {
            int val = n % 10;
            arr[i] = val;
            i++;
            n = n / 10;
        }
        reverse(arr, i);
        int tempArr[] = arr.clone();
        Arrays.sort(tempArr);
        reverse(tempArr, i);
        int index = 0;
        while (index < i) {
            if (tempArr[index] == arr[index]) {
                index++;
            } else {
                int temp = arr[index];
                arr[index] = tempArr[index];
                int p = i - 1;
                while (p > index) {
                    if (arr[p] == tempArr[index]) {
                        break;
                    }
                    p--;
                }
                arr[p] = temp;
                System.out.println("Helo");
                break;
            }

        }
        int res = 0;
        for (int x = 0; x < i; x++) {
            res = res * 10 + arr[x];
        }
        return res;
    }
}
