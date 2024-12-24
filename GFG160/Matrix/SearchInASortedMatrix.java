package GFG160.Matrix;

public class SearchInASortedMatrix {
    public static void main(String[] args) {
        // int mat[][] = { { 1, 5, 9 }, { 14, 20, 21 }, { 30, 34, 43 } }, k = 14;
        int mat[][] = { { 1, 3 } }, k = 3;
        System.out.println(searchMatrix(mat, k));
    }

    public static boolean searchMatrix(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        int l = 0;
        int r = n * m - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int x = mid / m;
            int y = mid % m;
            System.out.println(x);
            System.out.println(y);
            if (mat[x][y] == k) {
                return true;
            } else if (mat[x][y] > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
