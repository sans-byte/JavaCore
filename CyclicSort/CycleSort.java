package CyclicSort;

import java.util.Arrays;

//**********************/
// When Given numbers from range (1 , N) then we have to try and apply cyclic sort into questions
//**********************/
public class CycleSort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 2, 3, 1 };
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int lastIndex, int maxItemIndex) {
        int temp = arr[lastIndex];
        arr[lastIndex] = arr[maxItemIndex];
        arr[maxItemIndex] = temp;
    }

    static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }
    }
}
