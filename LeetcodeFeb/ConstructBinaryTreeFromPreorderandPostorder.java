package LeetcodeFeb;

public class ConstructBinaryTreeFromPreorderandPostorder {
    public static void main(String[] args) {
        
    }

    public TreeNode solve(int prestart, int poststart, int preend, int[] preorder, int[] postorder) {
        if (prestart > preend)
            return null;
        TreeNode root = new TreeNode(preorder[prestart]);
        if (prestart == preend)
            return root;

        int val = preorder[prestart + 1];
        int j = poststart;
        while (postorder[j] != val)
            j++;

        int num = j - poststart + 1;

        root.left = solve(prestart + 1, poststart, prestart + num, preorder, postorder);
        root.right = solve(prestart + num + 1, j + 1, preend, preorder, postorder);

        return root;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return solve(0, 0, preorder.length - 1, preorder, postorder);
    }
}
