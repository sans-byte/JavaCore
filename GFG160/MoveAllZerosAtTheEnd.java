package GFG160;

import java.util.*;

public class MoveAllZerosAtTheEnd {
    public static void main(String[] args) {
        // int arr[] = { 3, 4, 0, 0, 4 };
        int arr[] = { 1, 2, 0, 4, 3, 0, 5, 0 };
        pushZerosToEnd(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void pushZerosToEnd(int[] arr) {
        int temparr[] = new int[arr.length];
        int count = 0;
        int index = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                count++;
            }else{
                temparr[index] = arr[i];
                index++;
            }
        }
        while(count != 0 ){
            temparr[index] = 0;
            count--;
            index++;
        }
        
        for(int i=0;i<arr.length;i++){
            arr[i] = temparr[i];
        }
    }
}
