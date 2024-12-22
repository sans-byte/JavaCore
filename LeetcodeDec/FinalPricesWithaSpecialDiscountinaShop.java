import java.util.*;

public class FinalPricesWithaSpecialDiscountinaShop {
    public static void main(String[] args) {
        int prices[] = { 8, 4, 6, 2, 3 };
        System.out.println(finalPrices(prices));
    }

    public static int[] finalPrices(int[] prices) {
        Stack<Integer> s = new Stack<>();
        int res[] = new int[prices.length];
        for (int i = prices.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() > prices[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                res[i] = prices[i];
            } else {
                res[i] = prices[i] - s.peek();
            }
            s.add(prices[i]);
        }
        return res;
    }
}
