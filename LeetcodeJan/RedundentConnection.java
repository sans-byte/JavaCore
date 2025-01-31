package LeetcodeJan;

public class RedundentConnection {
    public static void main(String[] args) {
        int[][] edges = {
                { 1, 2 },
                { 2, 3 },
                { 3, 4 },
                { 1, 4 },
                { 1, 5 }
        };
        System.out.println(findRedundantConnection(edges));
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int res[] = new int[edges.length];
        return res;
    }
}
