package ArraysQuestions;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

//Almost like kadane's algo ( Maximum Subarray )

public class BestTimeToBuyAndSell {
    public static void main(String[] args) {
        int[] prices = { 1, 13, 1, 18 };

        System.out.println(bestBuySell(prices));
    }

    static int bestBuySell(int[] arr) {
        if (arr.length <= 1)
            return 0;

        int profit = 0;
        int i = 0;
        int j = 1;
        int sum = 0;

        while (i < arr.length && j < arr.length) {
            sum = arr[j] - arr[i];
            if (sum >= 0) {
                profit = Math.max(sum, profit);
                j++;
            } else {
                i++;
            }
        }
        return profit;
    }
}
