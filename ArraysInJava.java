import java.util.Arrays;
import java.util.Scanner;

class ArraysInJava {

    //When we define an array the default values of interger array is 0
    // Default values in String array is null
    // Null is a special literal that cannot be assigned to premitives 
    // String str = null 
    // int i = null; error
    public static void main(String[] args) {
        // different ways to initialize arrays
        // we have to either provide the size of the array or initialize it with some
        // values
        int arr[] = { 1, 2, 3, 4 };

        int arrr[] = new int[] { 2, 3, 4, 5 };
        System.out.println(arrr[2]);

        int arr1[] = new int[4];
        arr1[1] = 5;

        int[] arr3 = new int[5];
        arr3[2] = 10;

        System.out.println(arr1[1]);
        System.out.println(arr3[2]);

        // different ways to initialize 2d arrays
        int[][] array1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int[][] array2 = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array2[i][j] = i * 3 + j + 1;
            }
        }

        int[][] array3 = new int[3][3];
        array3[0] = new int[] { 1, 2, 3 };
        array3[1] = new int[] { 4, 5, 6 };
        array3[2] = new int[] { 7, 8, 9 };

        // Jagged array - we just specify the number of rows

        int[][] jagged = new int[3][];
        jagged[0] = new int[2];
        jagged[1] = new int[3];
        jagged[2] = new int[4];

        /////////////////

        int[][] jagged1 = new int[][] {
                { 1, 2 },
                { 3, 4, 5 },
                { 6, 7, 8, 9 }
        };

        // loop over jagged array

        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        // traversing the 2d array with for loop and jagged array

        for (int n[] : array3) {
            for (int m : n) {
                System.out.print(m + " ");
            }
            System.out.println();
        }

        // 3d arrays
        int[][][] array3d = new int[3][4][5];

        array3d[0][0][2] = 5;



        // ways to print array
        // Have already seen for loop and for each loop

        Scanner sc = new Scanner(System.in);
        int[] arrnew = new int[5];
        for(int i=0;i<arrnew.length;i++){
            arrnew[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(arrnew)); //this will print the array
    }



}
