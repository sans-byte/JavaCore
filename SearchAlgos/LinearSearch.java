package SearchAlgos;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(4);
        arr.add(26);
        arr.add(9);
        arr.add(3);
    }
    //Time complexity worst - O(n)
    
    static int linearSearch(ArrayList<Integer> arr, int target){
        // Edge case
        if(arr.size() <= 0){
            return -1;
        }

        for(int i=0;i< arr.size();i++){
            if(arr.get(i) == target){
                return i;
            }
        }
        return -1;
    }
}
