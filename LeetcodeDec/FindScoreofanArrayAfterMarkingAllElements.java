package LeetcodeDec;

public class FindScoreofanArrayAfterMarkingAllElements {
    public static void main(String[] args) {
        int nums[] = { 2, 3, 5, 1, 3, 2 };
        System.out.println(findScore(nums));
    }

    public static long findScore(int[] nums) {
        int arr[] = new int[nums.length];
        long res = 0;
        while (true) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < nums.length; j++) {
                if (arr[j] == 0) {
                    if (nums[j] < min) {
                        index = j;
                        min = nums[j];
                    }
                }
            }
            if (index == -1) {
                break;
            }
            res += min;
            arr[index] = 1;
            if (index + 1 < arr.length)
                arr[index + 1] = 1;
            if (index - 1 >= 0)
                arr[index - 1] = 1;
        }
        return res;
    }
}
