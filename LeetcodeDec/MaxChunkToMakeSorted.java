package LeetcodeDec;

public class MaxChunkToMakeSorted {
    public static void main(String[] args) {
        int arr[] = { 1, 0, 2, 3, 4 };
        System.out.println(maxChunksToSorted(arr));
    }

    public static int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            if (max == i)
                chunks++;
        }
        return chunks;
    }
}
