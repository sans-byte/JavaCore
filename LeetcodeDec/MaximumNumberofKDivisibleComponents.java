import java.util.*;

public class MaximumNumberofKDivisibleComponents {
    public static void main(String[] args) {
        int n = 7, edges[][] = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 2, 5 }, { 2, 6 } },
                values[] = { 3, 0, 6, 1, 5, 2, 1 }, k = 3;
        System.out.println(maxKDivisibleComponents(n, edges, values, k));
    }

    public static int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> l = new ArrayList<>();
        long scores[] = new long[n];
        for (int i = 0; i < n; i++)
            scores[i] = values[i];

        int degree[] = new int[n];

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            l.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            l.get(edges[i][0]).add(edges[i][1]);
            l.get(edges[i][1]).add(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }

        System.out.println(l);

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1)
                q.add(i);
        }

        int componentCount = 0;

        while (!q.isEmpty()) {
            int current = q.poll();
            System.out.println(current);
            degree[current]--;
            if (scores[current] % k == 0) {
                componentCount++;
            }
            for (Integer x : l.get(current)) {
                if (degree[x] > 0) {
                    degree[x]--;
                    scores[x] += scores[current];
                    if (degree[x] == 1)
                        q.add(x);
                }
            }

        }

        return componentCount;
    }
}
