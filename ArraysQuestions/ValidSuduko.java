package ArraysQuestions;

import java.util.Arrays;

public class ValidSuduko {
    public static void main(String[] args) {
        String[][] board = {
                { ".", ".", ".", ".", "5", ".", ".", "1", "." },
                { ".", "4", ".", "3", ".", ".", ".", ".", "." },
                { ".", ".", ".", ".", ".", "3", ".", ".", "1" },
                { "8", ".", ".", ".", ".", ".", ".", "2", "." },
                { ".", ".", "2", ".", "7", ".", ".", ".", "." },
                { ".", "1", "5", ".", ".", ".", ".", ".", "." },
                { ".", ".", ".", ".", ".", "2", ".", ".", "." },
                { ".", "2", ".", "9", ".", ".", ".", ".", "." },
                { ".", ".", "4", ".", ".", ".", ".", ".", "." }
        };

        // Output: true

        System.out.println(findValidSuduko(board));
    }

    static boolean findValidInBlock(int[][] sudoko, int i, int j) {
        int[] a = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        for (int x = i; x < i + 3; x++) {
            for (int y = j; y < j + 3; y++) {
                System.out.println(x + " " + y);
                if (sudoko[x][y] == -1)
                    continue;
                if (a[sudoko[x][y] - 1] == 1)
                    return false;
                a[sudoko[x][y] - 1] = 1;
            }
        }
        return true;
    }

    static boolean findValidSuduko(String[][] arr) {
        int[] a = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int[][] sudoko = new int[9][9];
        int i = 0;
        int j = 0;
        for (String[] str : arr) {
            j = 0;
            for (String s : str) {
                if (s == ".") {
                    sudoko[i][j] = -1;
                } else {
                    sudoko[i][j] = ((int) s.charAt(0)) - 48;
                }
                j++;
            }
            i++;
        }

        for (int x = 0; x < 9; x++) {
            for (int p = 0; p < 9; p++) {
                a[p] = 0;
            }
            for (int y = 0; y < 9; y++) {
                if (sudoko[x][y] == -1)
                    continue;
                if (a[sudoko[x][y] - 1] == 1)
                    return false;
                a[sudoko[x][y] - 1] = 1;
            }
        }
        for (int x = 0; x < 9; x++) {
            for (int p = 0; p < 9; p++) {
                a[p] = 0;
            }
            for (int y = 0; y < 9; y++) {
                if (sudoko[y][x] == -1)
                    continue;
                if (a[sudoko[y][x] - 1] == 1)
                    return false;
                a[sudoko[y][x] - 1] = 1;
            }
        }

        for (int m = 0; m < 9; m += 3) {
            for (int n = 0; n < 9; n += 3) {
                boolean res = findValidInBlock(sudoko, m, n);
                if (res == false)
                    return false;
            }
        }

        return true;
    }
}


// Have to study this question again and know a better short approach