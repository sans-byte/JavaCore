import java.util.*;

public class CountPairWithGivenSum{
    public static void main(String args[]) {
        int arr[] = {1, 5, 7, -1, 5}, target = 6; 
    }

    int countPairs(int arr[], int target) {
        int count = 0;
        Map<Integer, Integer> m = new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            int val = target - arr[i];
            if(m.containsKey(val)){
                count += m.get(val);
            }
            
            m.put(arr[i],m.getOrDefault(arr[i] , 0) + 1);
        }
        return count;
    }
}