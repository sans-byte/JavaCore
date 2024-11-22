package LeetOct;

import java.util.*;

// 1652. Defuse the Bomb

public class DefuseTheBomb {
    public static void main(String[] args) {
        int code[] = { 2, 4, 9, 3 }, k = -2;
        System.out.println(Arrays.toString(decrypt(code, k)));
    }

    public static int[] helper(int[] code, int k) {
        int res[] = new int[code.length];
        for (int i = 0; i < code.length; i++) {
            int x = (i + 1) % code.length;
            int count = 0;
            int sum = 0;
            while (count < k) {
                sum += code[x];
                count++;
                x++;
                x = x % code.length;
            }
            res[i] = sum;
        }
        return res;
    }

    public static int[] decrypt(int[] code, int k) {
        int res[] = new int[code.length];
        if (k > 0) {
            return helper(code, k);
        }
        if (k < 0) {
            List<Integer> l = new ArrayList<>();
            for (int i : code)
                l.add(i);
            Collections.reverse(l);
            int[] temp = helper(l.stream().mapToInt(i -> i).toArray(), -k); // List to array;
            System.out.println(Arrays.toString(temp));
            for (int i = temp.length - 1; i >= 0; i--)
                res[res.length - i - 1] = temp[i];
            return res;
        }
        return new int[code.length];
    }
}
