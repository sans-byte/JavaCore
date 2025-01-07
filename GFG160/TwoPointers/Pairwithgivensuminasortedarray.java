package GFG160.TwoPointers;

public class Pairwithgivensuminasortedarray {
    public static void main(String[] args) {
        int arr[] = {-1, 1, 5, 5, 7}, target = 6;
        System.out.println(countPairs(arr, target));
    }

    public static int countPairs(int arr[], int target) {
        int count = 0;
        int i=0;
        int j=arr.length-1;
        while(i<j){
            int val = arr[i] + arr[j];
            if(val == target){
                count++;
                int temp = i + 1;
                while(temp < j && arr[temp] == arr[temp-1]){
                    count++;
                    temp++;
                }
                j--;
            }
            else if(val > target){
                j--;
            }else{
                i++;
            }
        }
        return count;
    }
}
