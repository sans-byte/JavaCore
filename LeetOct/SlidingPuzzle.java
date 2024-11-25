package LeetOct;

//TODO : Redo it coz it uses BFS algo

//https://leetcode.com/problems/sliding-puzzle/description/

import java.util.*;

public class SlidingPuzzle {
    public static void main(String[] args) {
        int board[][] = { { 4, 1, 2 }, { 5, 0, 3 } };
        System.out.println(slidingPuzzle(board));
    }

    static int slidingPuzzle(int[][] board) {
        Set<String> s = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int arr[][] = new int[6][];
        arr[0] = new int[] { 1, 3 };
        arr[1] = new int[] { 0, 2, 4 };
        arr[2] = new int[] { 1, 5 };
        arr[3] = new int[] { 0, 4 };
        arr[4] = new int[] { 1, 3, 5 };
        arr[5] = new int[] { 2, 4 };

        String str = "";

        for (int[] i : board) {
            for (int j : i) {
                str += j;
            }
        }

        if (str.equals("123450"))
            return 0;

        s.add(str);
        q.add(str);
        int level = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            level++;
            for (int i = 0; i < len; i++) {
                String top = q.poll();
                int x = 0;
                while (x < top.length() && top.charAt(x) != '0') {
                    x++;
                }
                for (int pos = 0; pos < arr[x].length; pos++) {
                    StringBuilder strB = new StringBuilder(top);
                    char temp1 = strB.charAt(x);
                    strB.setCharAt(x, strB.charAt(arr[x][pos]));
                    strB.setCharAt(arr[x][pos], temp1);
                    String temp = new String(strB);
                    if (temp.equals("123450")) {
                        return level;
                    }
                    if (!s.contains(temp)) {
                        s.add(temp);
                        q.add(temp);
                    }
                }
            }
        }
        return -1;
    }
}
