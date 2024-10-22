package Tree;

public class CousinsInBinaryTree {

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

    public static boolean isCousins(TreeNode root, int x, int y) {
        int depth1[] = new int[1];
        int parent1[] = new int[1];
        int depth2[] = new int[1];
        int parent2[] = new int[1];
        findDepth(root, x, depth1, parent1, 0);
        findDepth(root, y, depth2, parent2, 0);
        return ((parent1[0] != parent2[0]) && (depth1[0] == depth2[0]));
    }

    public static void findDepth(TreeNode root, int value, int[] depth, int[] parent, int temp) {
        if (root == null)
            return;
        if ((root.left != null && root.left.val == value) | (root.right != null && root.right.val == value)) {
            parent[0] = root.val;
        }
        if (root.val == value) {
            depth[0] = temp;
            return;
        }
        temp++;
        findDepth(root.left, value, depth, parent, temp);
        findDepth(root.right, value, depth, parent, temp);
        temp--;
    }

    public static void main(String[] args) {
        int[] root = { 1, 2, 3, 4 };
        int x = 3;
        int y = 2;
        TreeNode rootNode = createTree(root, 0);
        System.out.println(isCousins(rootNode, x, y));
    }
}
