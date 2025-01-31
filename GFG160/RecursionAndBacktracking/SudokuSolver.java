package GFG160.RecursionAndBacktracking;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = {
                { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
        };

        solveSudoku(board);

        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int[][] mat, int value, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (mat[row][i] == value)
                return false;
            if (mat[i][col] == value)
                return false;
            if (mat[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == value)
                return false;
        }
        return true;
    }

    public static boolean solve(int[][] mat) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (mat[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if (isSafe(mat, k, i, j)) {
                            mat[i][j] = k;
                            if (solve(mat)) {
                                return true;
                            } else {
                                mat[i][j] = 0; // backtracking
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static void solveSudoku(int[][] mat) {
        solve(mat);
    }
}
