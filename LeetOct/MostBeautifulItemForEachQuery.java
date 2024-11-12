package LeetOct;

import java.util.*;

public class MostBeautifulItemForEachQuery {
    public static void main(String[] args) {
        int items[][] = { { 193, 732 }, { 781, 962 }, { 864, 954 }, { 749, 627 }, { 136, 746 }, { 478, 548 },
                { 640, 908 }, { 210, 799 }, { 567, 715 }, { 914, 388 }, { 487, 853 }, { 533, 554 }, { 247, 919 },
                { 958, 150 }, { 193, 523 }, { 176, 656 }, { 395, 469 }, { 763, 821 }, { 542, 946 }, { 701, 676 } };
        int queries[] = { 885, 1445, 1580, 1309, 205, 1788, 1214, 1404, 572, 1170, 989, 265, 153, 151, 1479, 1180, 875,
                276, 1584 };
        System.out.println(Arrays.toString(maximumBeauty(items, queries)));
    }

    public static int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, Comparator.comparing(x -> x[0]));
        for (int i = 1; i < items.length; i++) {
            items[i][1] = Math.max(items[i][1], items[i - 1][1]);
        }

        int res[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int s = 0;
            int e = items.length - 1;
            int max = 0;
            while (s <= e) {
                int mid = s + (e - s) / 2;
                if (items[mid][0] <= queries[i]) {
                    max = Math.max(max, items[mid][1]);
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
            res[i] = max;
        }
        return res;
    }
}
