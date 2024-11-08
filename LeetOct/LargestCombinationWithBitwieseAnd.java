package LeetOct;
// 2275. Largest Combination With Bitwise AND Greater Than Zero

import java.util.Arrays;

public class LargestCombinationWithBitwieseAnd {
    public static void main(String[] args) {
        int candidates[] = { 16, 17, 71, 62, 12, 24, 14 };
        System.out.println(8 & 1 << 3);
        System.out.println(largestCombination(candidates));
    }

    public static int largestCombination(int[] candidates) {
        int count = 0;
        int maxEle = Arrays.stream(candidates).max().getAsInt();
        System.out.println(maxEle);
        int maxCount = 0;
        for (int i = 0; i <= 23; i++) {
            if ((1 << i) > maxEle)
                break;
            count = 0;
            for (int x = 0; x < candidates.length; x++) {
                if (candidates[x] >= (1 << i)) {
                    if ((candidates[x] & (1 << i)) > 0) {
                        count++;
                    }
                }
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
