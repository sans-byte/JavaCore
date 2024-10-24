package Tree;

import java.util.*;

public class FlipEqulentBinaryTree {
    public static void main(String[] args) {
        int root1[] = { 1, 2, 3, 4, 5, 6, 0, 0, 0, 7, 8 };
        int root2[] = { 1, 3, 2, 0, 6, 4, 5, 0, 0, 0, 0, 8, 7 };
        TreeNode root1Tree = TreeNode.createTree(root1, 0);
        TreeNode root2Tree = TreeNode.createTree(root2, 0);
        System.out.println(flipEquiv(root1Tree, root2Tree));
    }

    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        if (root1.val != root2.val)
            return false;
        q1.add(root1);
        q2.add(root2);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode temp1 = q1.poll();
            TreeNode temp2 = q2.poll();

            System.out.println(temp1.val);
            System.out.println(temp2.val);
            if (temp1.val != temp2.val) {
                return false;
            }

            if ((temp1.left != null && temp2.left != null) && (temp1.right != null && temp2.right != null)) {
                if (temp1.left.val == temp2.left.val && temp1.right.val == temp2.right.val) {
                } else if (temp1.left.val == temp2.right.val && temp1.right.val == temp2.left.val) {
                    TreeNode node = temp1.left;
                    temp1.left = temp1.right;
                    temp1.right = node;
                } else {
                    return false;
                }
            }

            if (((temp1.left != null && temp1.right == null)
                    || (temp1.right != null && temp1.left == null))
                    && ((temp2.left != null && temp2.right == null)
                            || (temp2.right != null && temp2.left == null))) {
                int temp1ChildValue = temp1.left != null ? temp1.left.val : temp1.right.val;
                int temp2ChildValue = temp2.left != null ? temp2.left.val : temp2.right.val;
                if (temp1ChildValue != temp2ChildValue) {
                    return false;
                }

                if ((temp1.left != null && temp2.right != null) || (temp1.right != null && temp2.left != null)) {
                    temp1.left = temp1.right;
                    temp1.right = null;
                }
            }

            if (temp1.left != null)
                q1.add(temp1.left);
            if (temp1.right != null)
                q1.add(temp1.right);

            if (temp2.left != null)
                q2.add(temp2.left);
            if (temp2.right != null)
                q2.add(temp2.right);

        }
        if (q1.size() > 0 || q2.size() > 0) {
            return false;
        }
        return true;
    }
}
