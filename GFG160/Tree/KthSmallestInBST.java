package GFG160.Tree;

public class KthSmallestInBST {
    public static void main(String[] args) {
        
    }

    // first approach
    public static int i = 0;
    public static void inOrderToKthSmallest(TreeNode root, int k, int[] val) {
        if (root == null)
            return;

        inOrderToKthSmallest(root.left,k, val);
        i++;
        if (i == k) {
            val[0] = root.val;
            return;
        }
        inOrderToKthSmallest(root.right,k, val);
    }

    public int kthSmallest(TreeNode root, int k) {
        int val[] = new int[1];
        i = 0;
        inOrderToKthSmallest(root, k, val);
        return val[0];
    }
}
