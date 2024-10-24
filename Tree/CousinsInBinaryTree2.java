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

    public static TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int currentSum = 0;
        int sum = 0;
        q.add(root);
        int totalSum = root.val;
        while (!q.isEmpty()) {
            int levelLength = q.size();
            sum = 0;
            for (int i = 0; i < levelLength; i++) {
                currentSum = 0;
                TreeNode temp = q.poll();
                temp.val = totalSum - temp.val;
                if (temp.left != null) {
                    q.add(temp.left);
                    currentSum += temp.left.val;
                }
                if (temp.right != null) {
                    q.add(temp.right);
                    currentSum += temp.right.val;
                }
                if (temp.left != null) {
                    temp.left.val = currentSum;
                }
                if (temp.right != null) {
                    temp.right.val = currentSum;
                }
                sum += currentSum;
            }
            totalSum = sum;
        }
        return root;
    }

    // public static void main(String[] args) {
    // int root[] = { 5, 4, 9, 1, 10, 0, 7 };
    // TreeNode rootNode = TreeNode.createTree(root, 0);
    // System.out.println(TreeNode.levelOrder(rootNode));
    // replaceValueInTree(rootNode);
    // System.out.println(TreeNode.levelOrder(rootNode));
    // }

    // public static void getDepthAndParent(TreeNode root, TreeNode givenNode, int[]
    // depth, int currentDepth,
    // TreeNode[] parent) {
    // if (root == null)
    // return;
    // if ((root.left != null && root.left == givenNode) || (root.right != null &&
    // root.right == givenNode)) {
    // parent[0] = root;
    // }
    // if (root == givenNode) {
    // depth[0] = currentDepth;
    // return;
    // }
    // currentDepth++;
    // getDepthAndParent(root.left, givenNode, depth, currentDepth, parent);
    // getDepthAndParent(root.right, givenNode, depth, currentDepth, parent);
    // currentDepth--;
    // }

    // public static void getDepthAndParentMap(TreeNode root, int currentDepth,
    // Map<Integer, List<TreeNode>> depth,
    // Map<TreeNode, TreeNode> parent) {
    // if (root == null)
    // return;
    // if (root.left != null || root.right != null) {
    // if (root.left != null) {
    // parent.put(root.left, root);
    // }
    // if (root.right != null) {
    // parent.put(root.right, root);
    // }
    // }
    // if (depth.containsKey(currentDepth)) {
    // List<TreeNode> temp = depth.get(currentDepth);
    // temp.add(root);
    // depth.put(currentDepth, temp);
    // } else {
    // List<TreeNode> temp = new ArrayList<>();
    // temp.add(root);
    // depth.put(currentDepth, temp);
    // }

    // currentDepth++;
    // getDepthAndParentMap(root.left, currentDepth, depth, parent);
    // getDepthAndParentMap(root.right, currentDepth, depth, parent);
    // currentDepth--;
    // }

    // public static int getCousinsSum(TreeNode root, int currentDepth, TreeNode
    // parent,
    // int givenDepth, TreeNode givenParent, int sum) {
    // if (root == null)
    // return 0;
    // if (currentDepth > givenDepth) {
    // return 0;
    // }
    // if ((currentDepth == givenDepth) && (parent != givenParent)) {
    // return root.val;
    // }
    // currentDepth++;
    // sum += getCousinsSum(root.left, currentDepth, root, givenDepth, givenParent,
    // sum)
    // + getCousinsSum(root.right, currentDepth, root, givenDepth, givenParent,
    // sum);
    // currentDepth--;
    // return sum;
    // }

    // public static TreeNode replaceValueInTree(TreeNode root) {
    // Map<Integer, List<TreeNode>> depth = new HashMap<>();
    // Map<TreeNode, TreeNode> parent = new HashMap<>();
    // getDepthAndParentMap(root, 0, depth, parent);

    // Map<TreeNode, Integer> res = new HashMap<>();

    // for (List<TreeNode> i : depth.values()) {
    // for (int x = 0; x < i.size(); x++) {
    // int sum = 0;
    // for (TreeNode t : i) {
    // if (parent.get(i.get(x)) != parent.get(t)) {
    // sum += t.val;
    // }
    // }
    // res.put(i.get(x), sum);
    // }
    // }

    // for (TreeNode t : res.keySet()) {
    // t.val = res.get(t);
    // }

    // // int depth[] = new int[1];
    // // TreeNode parent[] = new TreeNode[1];
    // // // Run a loot on all nodes of tree and put the value there
    // // Map<TreeNode, Integer> m = new HashMap<>();
    // // Queue<TreeNode> q = new LinkedList<>();
    // // root.val = 0;
    // // q.add(root);
    // // while (!q.isEmpty()) {
    // // for (int i = 0; i < q.size(); i++) {
    // // TreeNode currentNode = q.poll();
    // // if (currentNode.left != null)
    // // q.add(currentNode.left);
    // // if (currentNode.right != null)
    // // q.add(currentNode.right);
    // // getDepthAndParent(root, currentNode, depth, 0, parent);
    // // int cousinSum = getCousinsSum(root, 0, new TreeNode(), depth[0],
    // parent[0],
    // // 0);
    // // m.put(currentNode, cousinSum);
    // // }
    // // }
    // // q.add(root);
    // // while (!q.isEmpty()) {
    // // for (int i = 0; i < q.size(); i++) {
    // // TreeNode currentNode = q.poll();
    // // if (currentNode.left != null)
    // // q.add(currentNode.left);
    // // if (currentNode.right != null)
    // // q.add(currentNode.right);
    // // if (m.containsKey(currentNode)) {
    // // currentNode.val = m.get(currentNode);
    // // }
    // // }
    // // }
    // // System.out.println(m);
    // return root;
    // }

}