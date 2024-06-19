package Strings;

// 4 4 4 4 4 4 4
// 4 3 3 3 3 3 4
// 4 3 2 2 2 3 4
// 4 3 2 1 2 3 4
// 4 3 2 2 2 3 4
// 4 3 3 3 3 3 4
// 4 4 4 4 4 4 4

// This pattern is tricky and have a different appraoch

// A value at perticular place is (n - min of it's distance from the four walls ( left, right, top, bottom))

public class PatternQuestion {

    public static void main(String[] args) {
        printPatter(4);
    }

    static void printPatter(int n) {
        int newN = 2 * n - 2;
        for (int i = 0; i <= newN; i++) {
            for (int j = 0; j <= newN; j++) {
                int value = n - Math.min(Math.min(i, j), Math.min(newN - i, newN - j));
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
