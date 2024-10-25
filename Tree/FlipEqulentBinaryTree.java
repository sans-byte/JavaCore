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
        return checker(root1, root2);
    }

    public static boolean checker(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }

        return (((checker(node1.left, node2.left)) || (checker(node1.left, node2.right)))
                && (checker(node1.right, node2.left) || checker(node1.right, node2.right)));
    }
}
