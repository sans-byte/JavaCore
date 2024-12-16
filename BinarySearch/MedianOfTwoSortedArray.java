package BinarySearch;

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 4, 7, 10, 12 };
        int[] arr2 = { 2, 3, 6, 15 };

        System.out.println(findMedian(arr1, arr2));
    }

    static double findMedian(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        if (n1 > n2)
            return findMedian(arr2, arr1); // Just to make sure that n1 is smaller array we are working on
        int left = (n1 + n2 + 1)/ 2;
        int start = 0;
        int end = n1 - 1;
        int n = n1 + n2;
        while(start <= end){
            int mid1 = start + (end - start)/2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if(mid1 < n1) r1 = arr1[mid1];
            if(mid2 < n2) r2 = arr2[mid2];
            if(mid1 - 1 >= 0) l1 = arr1[mid1-1];
            if(mid2 - 1 >= 0) l2 = arr2[mid2-1];

            if(l1 <= r2 && l2 <= r1 ){
                if(n %2 == 1) return Math.max(l1, l2);
                System.out.println(l1 + " " + l2 + " " + r1 + " " + r2);
                return (double) (Math.max(l1, l2) + Math.min( r1, r2)) / 2;
            }else{
                if(l2 > r1) start = mid1 + 1;
                else end = mid1 - 1;
            }
        }
        return 0;
    }
}
