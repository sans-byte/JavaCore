public class FinalPricesWithaSpecialDiscountinaShop {
    public static void main(String[] args) {
        
    }

    public int[] finalPrices(int[] prices) {
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
