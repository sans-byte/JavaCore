package BinarySearch;
//https://leetcode.com/problems/koko-eating-bananas/
public class KokoEatingBanana {
    public static void main(String[] args) {
        int[] arr = {312884470};
        int h = 968709470;

        System.out.println(findMinSpeed(arr,h));
    }

    static int findMinSpeed(int[] arr,int h){
        int start = 1; // Min speed it can have is 1 per hour
        int end = arr[0];   //Max speed it can have is largest pile per hour
        for(int i : arr){
            end = Math.max(i, end);
        }
        System.out.println(end);
        while(start < end){
            int mid = start + (end - start)/2;
            System.out.println(mid);
            int sumTime = 0;
            for(int j: arr){
                sumTime += j / mid;
                if(j % mid != 0) sumTime++;
            }
            if(sumTime <= h){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
    
}
