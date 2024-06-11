package SearchAlgos;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60,70,80,90};
        int target = 1000;
        System.out.println(binarySearch(arr,0,8,target));
    }


    static int binarySearch(int[] arr,int i,int j,int target){
        if(arr == null || arr.length <=0 || j < i) return -1; 
        int mid = i + (j - i)/2; //this won't exceed the limit
        if(arr[mid] == target) return mid;
        if(arr[mid] > target) return binarySearch(arr,i,mid ,target);
        if(arr[mid] < target) return binarySearch(arr, mid+1, j, target);
        return -1;
    }
}
