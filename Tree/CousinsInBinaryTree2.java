package Tree;

import java.util.*;

/**
 * CousinsInBinaryTree2
 */
public class CousinsInBinaryTree2 {
    public static void main(String[] args) {
        int root[] = { 5, 4, 9, 1, 10, 0, 7 };
        TreeNode rootNode = TreeNode.createTree(root, 0);
        System.out.println(TreeNode.levelOrder(rootNode));
        replaceValueInTree(rootNode);
        System.out.println(TreeNode.levelOrder(rootNode));
    }

    public static void getDepthAndParent(TreeNode root, TreeNode givenNode, int[] depth, int currentDepth,
            TreeNode[] parent) {
        if (root == null)
            return;
        if ((root.left != null && root.left == givenNode) || (root.right != null && root.right == givenNode)) {
            parent[0] = root;
        }
        if (root == givenNode) {
            depth[0] = currentDepth;
            return;
        }
        currentDepth++;
        getDepthAndParent(root.left, givenNode, depth, currentDepth, parent);
        getDepthAndParent(root.right, givenNode, depth, currentDepth, parent);
        currentDepth--;
    }

    public static int getCousinsSum(TreeNode root, int currentDepth, TreeNode parent,
            int givenDepth, TreeNode givenParent, int sum) {
        if (root == null)
            return 0;
        if (currentDepth > givenDepth) {
            return 0;
        }
        if ((currentDepth == givenDepth) && (parent != givenParent)) {
            return root.val;
        }
        currentDepth++;
        sum += getCousinsSum(root.left, currentDepth, root, givenDepth, givenParent, sum)
                + getCousinsSum(root.right, currentDepth, root, givenDepth, givenParent, sum);
        currentDepth--;
        return sum;
    }

    public static TreeNode replaceValueInTree(TreeNode root) {
        int depth[] = new int[1];
        TreeNode parent[] = new TreeNode[1];
        // Run a loot on all nodes of tree and put the value there
        Map<TreeNode, Integer> m = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        root.val = 0;
        q.add(root);
        while (!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                TreeNode currentNode = q.poll();
                if (currentNode.left != null)
                    q.add(currentNode.left);
                if (currentNode.right != null)
                    q.add(currentNode.right);
                getDepthAndParent(root, currentNode, depth, 0, parent);
                int cousinSum = getCousinsSum(root, 0, new TreeNode(), depth[0], parent[0], 0);
                m.put(currentNode, cousinSum);
            }
        }
        q.add(root);
        while (!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                TreeNode currentNode = q.poll();
                if (currentNode.left != null)
                    q.add(currentNode.left);
                if (currentNode.right != null)
                    q.add(currentNode.right);
                if(m.containsKey(currentNode)){
                    currentNode.val = m.get(currentNode);
                }
            }
        }
        System.out.println(m);
        return root;
    }

}