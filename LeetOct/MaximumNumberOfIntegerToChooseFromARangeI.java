package LeetOct;

public class MaximumNumberOfIntegerToChooseFromARangeI {
    public static void main(String[] args) {
        int banned[] = { 1, 6, 5 }, n = 5, maxSum = 6;
        System.out.println(maxCount(banned, n, maxSum));
    }

    public static int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> s = new HashSet<>();
        for (int i : banned)
            s.add(i);
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!s.contains(i)) {
                int temp = sum + i;
                if (temp > maxSum) {
                    return count;
                }
                sum = temp;
                count++;
            }
        }
        return count;
    }
}
