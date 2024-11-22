package GFG160;
// Stock Buy and Sell – Multiple Transaction Allowed

import java.util.*;

public class StockByAndSellMultipleTransactionAllowed {
    public static void main(String[] args) {
        // int prices[] = { 100, 180, 260, 310, 40, 535, 695 };
        int prices[] = { 86, 92, 24, 5, 34, 72, 68, 52, 27, 95, 41, 28, 35 };
        System.out.println(maximumProfit(prices));
    }

    public static int maximumProfit(int prices[]) {
        int i = 0, j = 1, profit = 0, maxProfit = 0;
        boolean flag = false;
        while (i < prices.length && j < prices.length) {
            if (prices[j] - prices[i] > profit) {
                profit = prices[j] - prices[i];
                flag = false;
            } else {
                if (flag == false) {
                    i = j;
                    flag = true;
                } else {
                    if (prices[j] < prices[i]) {
                        i = j;
                    }
                }
                maxProfit += profit;
                profit = 0;
            }
            j++;
        }
        maxProfit += profit;
        return maxProfit;
    }
}
