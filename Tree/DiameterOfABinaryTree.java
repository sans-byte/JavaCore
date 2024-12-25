package Tree;

public class DiameterOfABinaryTree {
    public static void main(String[] args) {
        int root[] = { 1, 2, 3, 4, 5 };
        System.out.println(diameterOfBinaryTree(root));
    }

    public static int helper(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left, res);
        int right = helper(root.right, res);

        res[0] = Math.max(res[0], right + left);
        return 1 + Math.max(left, right);
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        int res[] = new int[1];
        helper(root, res);
        return res[0];
    }
}

// Complexity is O(N) as we are traversing every node only once
