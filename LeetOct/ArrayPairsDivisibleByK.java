package LeetOct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/description/?envType=daily-question&envId=2024-10-01

public class ArrayPairsDivisibleByK {
  public static void main(String[] args) {
    int arr[] = { -1, -1, -1, -1, 2, 2, -2, -2 };
    int k = 3;
    System.out.println(canArrange(arr, k));
  }

  static boolean canArrange(int[] arr, int k) {
    int freq[] = new int[k];
    for (int i = 0; i < arr.length; i++) {
      int a = arr[i] % k;
      if (a < 0) {
        a = a + k;
      }
      freq[a]++;
    }
    if (freq[0] % 2 != 0) {
      return false;
    }

    System.out.println(Arrays.toString(freq));

    for (int i = 1; i <= k / 2; i++) {
      if (freq[i] != freq[k - i]) {
        return false;
      }
    }
    return true;
  }
}
