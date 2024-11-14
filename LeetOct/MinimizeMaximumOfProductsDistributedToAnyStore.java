package LeetOct;

// 2064. Minimized Maximum of Products Distributed to Any Store

public class MinimizeMaximumOfProductsDistributedToAnyStore {
    public static void main(String[] args) {
        int n = 7, quantities[] = { 15, 10, 10 };
        System.out.println(minimizedMaximum(n, quantities));
    }

    public static int minimizedMaximum(int n, int[] quantities) {
        int s = 0;
        int e = quantities[0];
        for (int i : quantities) {
            e = Math.max(i, e);
        }

        while (s <= e) {
            int mid = s + (e - s) / 2;
            System.out.println(mid);
            int products = 0;
            for (int i = 0; i < quantities.length; i++) {
                products += quantities[i] / mid;
                if (quantities[i] % mid != 0) {
                    products++;
                }
            }
            if (products <= n) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        System.out.println(s);
        return 0;
    }
}
