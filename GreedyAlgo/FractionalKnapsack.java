package GreedyAlgo;

import java.util.Arrays;

class Item {
    int value;
    int weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsack {
    public static void main(String[] args) {
        int w = 50;
        int[] value = { 60, 100, 120 };
        int[] weight = { 10, 20, 30 };

        Item[] items = new Item[value.length];
        for (int i = 0; i < value.length; i++) {
            Item x = new Item(value[i], weight[i]);
            items[i] = x;
        }

        System.out.println(fracKnapsack(w, items));
    }

    static double fracKnapsack(int w, Item[] items) {
        Arrays.sort(items, (a, b) -> {
            double ratioA = (double) a.value / a.weight;
            double ratioB = (double) b.value / b.weight;
            return Double.compare(ratioB, ratioA);
        });

        int i = 0;
        double total = 0;
        while (i < items.length) {
            if (items[i].weight <= w) {
                w -= items[i].weight;
                total += items[i].value;
            } else {
                total += ((double) (items[i].value * w) / (double) items[i].weight);
                break;
            }
            i++;
        }
        return total;
    }
}
