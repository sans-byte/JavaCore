package Tree;

import java.util.*;

// 2458. Height of Binary Tree After Subtree Removal Queries

public class HeightOfBinaryTree {
    public static void main(String[] args) {
        int root[] = { 5, 8, 9, 2, 1, 3, 7, 4, 6 };
        int quaries[] = { 3, 2, 4, 8 };
        TreeNode nodeRoot = TreeNode.createTree(root, 0);
        System.out.println(Arrays.toString(treeQueries(nodeRoot, quaries)));
    }

    public static int getAllHeights(TreeNode root, Map<Integer, Integer> l, Map<Integer, Integer> r) {
        if (root == null)
            return 0;

        int lh = getAllHeights(root.left, l, r);
        int rh = getAllHeights(root.right, l, r);

        l.put(root.val, lh);
        r.put(root.val, rh);

        return Math.max(lh, rh) + 1;
    }

    public static void solve(TreeNode root, int maxHeight, int depth, Map<Integer, Integer> l, Map<Integer, Integer> r,
            Map<Integer, Integer> h) {
        if (root == null)
            return;

        h.put(root.val, maxHeight);

        solve(root.left, Math.max(maxHeight, depth + r.get(root.val)), depth + 1, l, r, h);
        solve(root.right, Math.max(maxHeight, depth + l.get(root.val)), depth + 1, l, r, h);
    }

    public static int[] treeQueries(TreeNode root, int[] queries) {
        int res[] = new int[queries.length];
        Map<Integer, Integer> l = new HashMap<>();
        Map<Integer, Integer> r = new HashMap<>();
        Map<Integer, Integer> h = new HashMap<>();
        getAllHeights(root, l, r);
        solve(root, 0, 0, l, r, h);
        for (int i = 0; i < queries.length; i++) {
            res[i] = h.get(queries[i]);
        }
        return res;
    }
}
