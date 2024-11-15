package BinarySearch;

// 1011. Capacity To Ship Packages Within D Days

public class CapacityToShitPackagesInDDays {
    public static void main(String[] args) {
        int weights[] = { 3, 2, 2, 4, 1, 4 }, days = 3;
        shipWithinDays(weights, days);
    }

    public static int shipWithinDays(int[] weights, int days) {
        int s = 0;
        int e = 0;
        for (int i : weights) {
            e += i;
            s = Math.max(s, i);
        }

        while (s <= e) {
            int dayCount = 1;
            int tempWeight = 0;
            int mid = s + (e - s) / 2;
            for (int i = 0; i < weights.length; i++) {
                tempWeight += weights[i];
                if (tempWeight > mid) {
                    dayCount++;
                    tempWeight = weights[i];
                }
            }

            if (dayCount > days) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        System.out.println(s);
        return 0;
    }
}
