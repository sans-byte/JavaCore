package GFG160.TwoPointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int arr[] = { 3, 1, 2, 4, 5 };
        System.out.println(maxWater(arr));
    }

    public static int maxWater(int arr[]) {
        int i=0,j=arr.length-1,res=0;
        
        while(i<j){
            res = Math.max(res,Math.min(arr[i],arr[j]) * (j-i));
            if(arr[i] > arr[j]){
                j--;
            }else{
                i++;
            }
        }
        return res;
    }
}
