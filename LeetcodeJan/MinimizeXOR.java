package LeetcodeJan;

import java.util.Arrays;

public class MinimizeXOR {
    public static void main(String[] args) {
        int num1 = 1, num2 = 12;
        System.out.println(minimizeXor(num1, num2));
    }

    public static int minimizeXor(int num1, int num2) {
        int res = 0;
        int arr1[] = new int[31];
        int arr2[] = new int[31];
        Arrays.fill(arr1, 0);

        int n1 = num1;
        int n2 = num2;
        int index = 0;
        while (n1 != 0) {
            arr1[index] = n1 % 2;
            n1 = n1 / 2;
            index++;
        }

        int bitCount = 0;
        while (n2 != 0) {
            if ((n2 % 2) == 1)
                bitCount++;
            n2 = n2 / 2;
        }

        System.out.println(bitCount);
        System.out.println(Arrays.toString(arr1));

        for (int i = arr1.length - 1; i >= 0 && bitCount > 0; i--) {
            if (arr1[i] == 1) {
                arr2[i] = 1;
                bitCount--;
            }
        }

        for (int i = 0; i < arr1.length && bitCount > 0; i++) {
            if (arr1[i] == 0) {
                arr2[i] = 1;
                bitCount--;
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] == 1)
                bitCount++;
        }

        for (int i = 0; i < arr2.length && bitCount > 0; i++) {
            if (arr2[i] == 1) {
                res += Math.pow(2, i);
                bitCount--;
            }
        }
        return res;
    }
}
