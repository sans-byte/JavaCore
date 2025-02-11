public class CheckForBST {
    public static void main(String[] args) {
        
    }

    public static boolean helper(TreeNode root, int curr) {
        if (root == null)
            return true;
        if (root.left != null && root.left.val >= curr)
            return false;
        if (root.right != null && root.right.val <= curr)
            return false;

        if (root.left != null && root.right != null) {
            return helper(root.left, root.left.val) && helper(root.right, root.right.val);
        } else if (root.left != null)
            return helper(root.left, root.left.val);
        else if (root.right != null)
            return helper(root.right, root.right.val);
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, root.val);
    }
}
