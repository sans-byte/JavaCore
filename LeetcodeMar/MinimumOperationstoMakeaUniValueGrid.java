package LeetcodeMar;

public class MinimumOperationstoMakeaUniValueGrid {
    public static void main(String[] args) {
        int grid[][] = { { 2, 4 }, { 6, 8 } }, x = 2;
        System.out.println(minOperations(grid, x));
    }

    public static int minOperations(int[][] grid, int x) {
        double remainder = grid[0][0] % x;
        int n = grid.length;
        int m = grid[0].length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                double value = grid[i][j] % x;
                sum += grid[i][j];
                if (value != remainder)
                    return -1;
            }
        }
        int round = Math.round(sum / (n * m));
        int value = grid[0][0];
        int factor = Math.abs(value - round);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int fac = Math.abs(grid[i][j] - round);
                if (fac < factor) {
                    factor = fac;
                    value = grid[i][j];
                }
            }
        }
        System.out.println(value);
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res += Math.abs(grid[i][j] - value) / x;
            }
        }
        return res;
    }
}
