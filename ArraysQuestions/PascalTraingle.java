package ArraysQuestions;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/

public class PascalTraingle {
    public static void main(String[] args) {
        int numRows = 5;

        System.out.println(pascleTraingle(numRows));
    }

    static List<List<Integer>> pascleTraingle(int rows) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        while (i <= rows) {
            int j = i + 1;
            List<Integer> oldList = new ArrayList<>();
            if (i > 0) {
                oldList = ans.get(i - 1);
            }
            List<Integer> l = new ArrayList<>();
            for (int x = 0; x < j; x++) {
                if (x == 0 || x == j - 1) {
                    l.add(1);
                    continue;
                }
                int value = oldList.get(x - 1) + oldList.get(x);
                l.add(value);
            }
            ans.add(l);
            i++;
        }

        return ans;
    }
}
