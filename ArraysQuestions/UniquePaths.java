package ArraysQuestions;

// https://leetcode.com/problems/unique-paths/submissions/
public class UniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        System.out.println(findNumberOfUniquePaths(m, n));
    }

    private static int findNumberOfUniquePaths(int m, int n) {

        // Recursive solution the time complexity of this soln is exponentional
        // if (m < 1 || n < 1)
        // return 0;
        // if (m == 1 && n == 1)
        // return 1;

        // return findNumberOfUniquePaths(m - 1, n) + findNumberOfUniquePaths(m, n - 1);

        // DP solution

        // int[][] DPTable = new int[m][n];
        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // DPTable[i][j] = -1;
        // }
        // }
        // return findNumberOfUniquePathsDP(m, n, DPTable);

        // This problem is basically a permuatation combination problem
        // __ __ __
        // |__|__|__| m = 2 n=3 All combinations = RRB, RBR, BRR
        // |__|__|__| we can see there that to reach last index we have to take certain
        // amount of Right and Bottom
        // That is Right = n-1 AND Bottom = m-1 total we need Right + Bottom = m + n - 2
        // steps to react the bottom
        // Here steps = m + n - 2 = 2+3-2 = 3
        // Bottom will take m-1 = 1 place and Right will take n-1 = 2 places so the ans
        // will be ((m+n-2)Cright) or ((m+n-2)Cbottom)

        int N = m + n - 2;
        int r = n - 1;
        int res = 1;

        for (int i = 1; i <= r; i++) {
            res = res * (N - r + i) / i;
        }
        return res;
    }

    // private static int findNumberOfUniquePathsDP(int m, int n, int[][] dPTable) {
    // if (m < 1 || n < 1)
    // return 0;
    // if (m == 1 && n == 1)
    // return 1;
    // if (dPTable[m - 1][n - 1] != -1)
    // return dPTable[m - 1][n - 1];
    // return dPTable[m - 1][n - 1] = findNumberOfUniquePathsDP(m - 1, n, dPTable)
    // + findNumberOfUniquePathsDP(m, n - 1, dPTable);
    // }
}
