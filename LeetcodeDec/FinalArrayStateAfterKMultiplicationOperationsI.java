
import java.util.*;

public class FinalArrayStateAfterKMultiplicationOperationsI {
    public static void main(String[] args) {
        int nums[] = { 2, 1, 3, 5, 6 }, k = 5, multiplier = 2;
        System.out.println(Arrays.toString(getFinalState(nums, k, multiplier)));
    }

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] x, int[] y) {
                if (x[0] == y[0])
                    return Integer.compare(x[1], y[1]);
                return Integer.compare(x[0], y[0]);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[] { nums[i], i });
        }

        for (int i = 0; i < k; i++) {
            int val[] = pq.poll();
            nums[val[1]] = val[0] * multiplier;
            pq.add(new int[] { val[0] * multiplier, val[1] });
        }
        return nums;
    }
}
