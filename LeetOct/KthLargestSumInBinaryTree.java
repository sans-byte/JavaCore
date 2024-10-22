package LeetOct;

import java.util.*;

public class KthLargestSumInBinaryTree {

    public static class TreeNode {
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

        System.out.println(n.val);
        postOrder(n.left);
        postOrder(n.right);
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
                if (tempNode.right != null)
                    q.add(tempNode.right);

                if (tempNode.left != null)
                    q.add(tempNode.left);

                temp.add(tempNode.val);
            }
            res.add(temp);
        }
        return res;
    }

    public static List<Long> levelOrderSum(TreeNode n) {
        List<Long> res = new ArrayList<>();
        if (n == null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            long sum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode tempNode = q.poll();
                if (tempNode.right != null)
                    q.add(tempNode.right);
                if (tempNode.left != null)
                    q.add(tempNode.left);
                sum += tempNode.val;
            }
            res.add(sum);
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 0, 3 };
        int k = 1;
        TreeNode n = createTree(arr, 0);
        postOrder(n);
        System.out.println(levelOrder(n));
        List<Long> res = levelOrderSum(n);
        res.sort(null);
        System.out.println(res);
    }
}
