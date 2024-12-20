/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public static void reverseValues(List<TreeNode> l) {
        int i = 0, j = l.size() - 1;
        while (i < j) {
            int temp = l.get(i).val;
            l.get(i).val = l.get(j).val;
            l.get(j).val = temp;
            i++;
            j--;
        }
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            List<TreeNode> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    l.add(node.left);
                    l.add(node.right);
                }
            }
            if (level % 2 == 0) {
                reverseValues(l);
            }
            for (int i = 0; i < l.size(); i++) {
                q.add(l.get(i));
            }
            level++;
        }
        return root;
    }
}


// best solution 

public static void reverse(TreeNode left, TreeNode right,int level){
    if(left == null) return;
    reverse(left.left,right.right,level+1);
    reverse(left.right,right.left,level+1);
    if(level % 2 == 0){
        int temp = left.val;
        left.val = right.val;
        right.val = temp;
    }
}
public TreeNode reverseOddLevels(TreeNode root) {
    reverse(root.left,root.right,0);
    return root;
}
}