package BinarySearch;

public class SearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 20;
        System.out.println(findInMatrix(matrix, target));
    }

    static boolean findInMatrix(int[][] arr,int target) {
        int arrlen = arr.length - 1;
        System.out.println(arrlen);
        int row = 0;
        int col = arr[0].length - 1;
        while (row <= arrlen && col >= 0) {
            if(arr[row][col] == target ) return true;
            if(arr[row][col] < target){
                row++;
            }
            else if(arr[row][col] > target){
                col--;
            }
        }
        return false;
    }
}
