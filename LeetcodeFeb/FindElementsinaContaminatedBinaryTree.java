package LeetcodeFeb;

import java.util.HashSet;
import java.util.Set;

public class FindElementsinaContaminatedBinaryTree {
    public static void main(String[] args) {

    }

    class FindElements {
        public static Set<Integer> set = new HashSet<>();

        public static void generateValues(TreeNode root) {
            if (root == null)
                return;

            if (root.left != null) {
                int value = 2 * root.val + 1;
                set.add(value);
                root.left.val = value;
                generateValues(root.left);
            }

            if (root.right != null) {
                int value = 2 * root.val + 2;
                set.add(value);
                root.right.val = value;
                generateValues(root.right);
            }
        }

        public FindElements(TreeNode root) {
            set.clear();
            root.val = 0;
            set.add(0);
            generateValues(root);
        }

        public boolean find(int target) {
            return set.contains(target);
        }
    }
}
