package Tree;

import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTree(int[] vals, int i) {
        if (i >= vals.length)
            return null;

        TreeNode root = new TreeNode(vals[i]);
        root.left = createTree(vals, 2 * i + 1);
        root.right = createTree(vals, 2 * i + 2);
        return root;
    }

    public static void postOrder(TreeNode n) {
        if (n == null)
            return;

        postOrder(n.left);
        postOrder(n.right);
        System.out.print(n.val + " ");
    }

    public static void preOrder(TreeNode n) {
        if (n == null)
            return;

        System.out.print(n.val + " ");
        preOrder(n.left);
        preOrder(n.right);
    }

    public static void inOrder(TreeNode n) {
        if (n == null)
            return;
        inOrder(n.left);
        System.out.print(n.val + " ");
        inOrder(n.right);
    }

    public static List<List<Integer>> levelOrder(TreeNode n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode tempNode = q.poll();
                if (tempNode.left != null)
                    q.add(tempNode.left);

                if (tempNode.right != null)
                    q.add(tempNode.right);

                temp.add(tempNode.val);
            }
            res.add(temp);
        }
        return res;
    }
}
